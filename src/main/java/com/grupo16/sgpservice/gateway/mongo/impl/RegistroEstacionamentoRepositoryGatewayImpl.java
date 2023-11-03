package com.grupo16.sgpservice.gateway.mongo.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.domain.Preco;
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
			
			RegistroEstacionamentoDocument reDocument = registroEstacionamentoRepository.findById(id).get();
			
			TabelaPrecoDocument tabelaPreco = tabelaPrecoRepository.findByVigencia(null);
			
			
			Tarifa tarifa = Tarifa.builder()
					.id(id)
					.valorUnitario(tabelaPreco.getPrecoHora())
					.tabelaHoraPreco(tabelaPreco.getPrecosHora().stream().map(pe -> Preco.builder().hora(pe.getHora()).valor(pe.getValor()).build()).toList())
					.build();
			
			RegistroEstacionamentoBase re = null;
			Condutor condutor = Condutor.builder()
					.id(reDocument.getVeiculo().getCondutor().getId())
					.nome(reDocument.getVeiculo().getCondutor().getNome())
					.cpf(reDocument.getVeiculo().getCondutor().getCpf())
					.build();
					
			Veiculo veiculo = Veiculo.builder()
					.id(reDocument.getVeiculo().getId())
					.placa(reDocument.getVeiculo().getPlaca())
					.condutor(condutor)
					.build();
			
			if(TipoEstacionamento.TEMPO_FIXO.equals(reDocument.getTipo())) {
				re = RegistroEstacionamentoPeriodoFixo.builder()
						.id(id)
						.dataHoraInicio(reDocument.getDataHoraInicio())
						.dataHoraTermino(reDocument.getDataHoraTermino())
						.quantidadeHoras(reDocument.getQuantidadeHoras())
						.veiculo(veiculo)
						.tarifa(tarifa)
						.build();
 			} else {
				re = RegistroEstacionamentoPeriodoVariavel.builder()
						.id(id)
						.dataHoraInicio(reDocument.getDataHoraInicio())
						.dataHoraTermino(reDocument.getDataHoraTermino())
						.veiculo(veiculo)
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
	public Optional<RegistroEstacionamentoBase> getByIdAndPagamentoStatus(String id, String status) {
		
		try {
			Optional<RegistroEstacionamentoDocument> reDocumentOptional = registroEstacionamentoRepository.findByIdAndPagamentoStatus(id, status);
			
			Optional<RegistroEstacionamentoBase> reOptional = Optional.empty();
			
			if(reDocumentOptional.isPresent()) {
				reOptional = Optional.of(reDocumentOptional.get().parseRegistroDomain());
			}
			
			return reOptional;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
	}

	@Override
	public List<RegistroEstacionamentoBase> getByDataHoraPrevisaoNotificacaoBetween(
			LocalDateTime dataHoraInicio, LocalDateTime dataHoraTermino) {
		
		try {
			List<RegistroEstacionamentoDocument> registrosDocument = registroEstacionamentoRepository.findByDataHoraTerminoBetween(dataHoraInicio, dataHoraTermino);
			
			List<RegistroEstacionamentoBase> registros = registrosDocument.stream().map(re -> re.parseRegistroDomain()).toList();
			
			return registros;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
	}

	@Override
	@Transactional
	public void salvar(List<RegistroEstacionamentoBase> registrosEstacionamento) {
		registrosEstacionamento.forEach(this::salvar);
	}

	@Override
	public Optional<RegistroEstacionamentoBase> getBySolicitacaoPagamento(String solicitacaoPagamentoId) {
		try {
			Optional<RegistroEstacionamentoDocument> pagamentoEntityOp = registroEstacionamentoRepository.findByPagamentoIdSolicitacaoPagamento(solicitacaoPagamentoId);
			
			Optional<RegistroEstacionamentoBase> registroEstacionamentoOp = Optional.empty();
			
			if(pagamentoEntityOp.isPresent()) {
				registroEstacionamentoOp = Optional.of(pagamentoEntityOp.get().parseRegistroDomain());
			}
			
			return registroEstacionamentoOp;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
	}

}
