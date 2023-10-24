package com.grupo16.sgpservice.gateway.mongo.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoPeriodoFixo;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoPeriodoVariavel;
import com.grupo16.sgpservice.domain.Tarifa;
import com.grupo16.sgpservice.domain.TipoEstacionamento;
import com.grupo16.sgpservice.domain.Veiculo;
import com.grupo16.sgpservice.exception.ErroAoAcessarBancoDadosException;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;
import com.grupo16.sgpservice.gateway.mongo.document.RegistroEstacionamentoDocument;
import com.grupo16.sgpservice.gateway.mongo.document.TabelaPrecoDocument;
import com.grupo16.sgpservice.gateway.mongo.repository.RegistroEstacionamentoRepository;
import com.grupo16.sgpservice.gateway.mongo.repository.TabelaPrecoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegistroEstacionamentoRepositoryGatewayImpl implements RegistroEstacionamentoRepositoryGateway {

	@Autowired
	private RegistroEstacionamentoRepository registroEstacionamentoRepository;
	
	@Autowired
	private TabelaPrecoRepository tabelaPrecoRepository;
	
	
	@Override
	public String salvar(RegistroEstacionamentoBase registroEstacionamento) {
		try {
			return registroEstacionamentoRepository.save(new RegistroEstacionamentoDocument(registroEstacionamento)).getId();
			
		} catch (Exception e) {
			log.warn("Error to process. registroEstacionamentoBase={}", registroEstacionamento);
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
		
	}

	@Override
	public RegistroEstacionamentoBase getById(String id) {
		try {
			
			RegistroEstacionamentoDocument registroEstacionamentoDocument = registroEstacionamentoRepository.findById(id).get();
			
			TabelaPrecoDocument tabelaPreco = tabelaPrecoRepository.findByVigencia(null);
			Tarifa tarifa = Tarifa.builder()
					.id(id)
					.valorUnitario(tabelaPreco.getPrecoHora())
					.tabelaHoraPreco(tabelaPreco.getPrecosHora())
					.build();
			
			RegistroEstacionamentoBase re = null;
			if(TipoEstacionamento.TEMPO_FIXO.equals(registroEstacionamentoDocument.getTipo())) {
				re = RegistroEstacionamentoPeriodoFixo.builder()
						.id(id)
						.dataHoraInicio(registroEstacionamentoDocument.getDataHoraInicio())
						.dataHoraTermino(registroEstacionamentoDocument.getDataHoraTermino())
						.quantidadeHoras(registroEstacionamentoDocument.getQuantidadeHoras())
						.veiculo(Veiculo.builder().id(registroEstacionamentoDocument.getVeiculo().getId()).build())
						.tarifa(tarifa)
						.build();
			} else {
				re = RegistroEstacionamentoPeriodoVariavel.builder()
						.id(id)
						.dataHoraInicio(registroEstacionamentoDocument.getDataHoraInicio())
						.dataHoraTermino(registroEstacionamentoDocument.getDataHoraTermino())
						.veiculo(Veiculo.builder().id(registroEstacionamentoDocument.getVeiculo().getId()).build())
						.tarifa(tarifa)
						.build();
			}
			
			return re;
			
		} catch (Exception e) {
			log.warn("Error to process. id={}", id);
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
	}

	@Override
	public List<RegistroEstacionamentoBase> getByDataHoraPrevisaoNotificacaoBetween(
			LocalDateTime dataHoraInicio, LocalDateTime dataHoraTermino) {
		
		List<RegistroEstacionamentoDocument> registrosDocument = registroEstacionamentoRepository.findByDataHoraTerminoBetween(dataHoraInicio, dataHoraTermino);
		System.out.println("Document: "+ registrosDocument);
		
		List<RegistroEstacionamentoBase> registros = registrosDocument.stream().map(re -> re.parseRegistroDomain()).toList();
		System.out.println("Domain: "+ registros);
		
		return registros;
	}

	@Override
	@Transactional
	public void salvar(List<RegistroEstacionamentoBase> registrosEstacionamento) {
		registrosEstacionamento.forEach(this::salvar);
	}

}
