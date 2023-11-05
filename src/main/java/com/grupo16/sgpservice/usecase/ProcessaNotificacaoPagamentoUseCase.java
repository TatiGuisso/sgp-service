package com.grupo16.sgpservice.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.NotificacaoPagamento;
import com.grupo16.sgpservice.domain.Pagamento;
import com.grupo16.sgpservice.domain.Preco;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.domain.Tarifa;
import com.grupo16.sgpservice.gateway.PagamentoGateway;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;
import com.grupo16.sgpservice.gateway.mongo.document.TabelaPrecoDocument;
import com.grupo16.sgpservice.gateway.mongo.repository.TabelaPrecoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessaNotificacaoPagamentoUseCase {

	@Autowired
	private RegistroEstacionamentoRepositoryGateway registroEstacionamentoRepositoryGateway;
	
	@Autowired
	private PagamentoGateway pagamentoGateway;
	
	@Autowired
	private TabelaPrecoRepository tabelaPrecoRepository;
	
	public void processa(NotificacaoPagamento notificacaoPagamento) {
		
		Optional<RegistroEstacionamentoBase> rEstacionamentoOp = registroEstacionamentoRepositoryGateway.getBySolicitacaoPagamento(notificacaoPagamento.getSolicitacaoPagamentoId());
		
		if(rEstacionamentoOp.isEmpty()) {
			log.warn("Solicitação de pagamento não encontrada no sistema! Ignorando...");
			return;
		}
		
		TabelaPrecoDocument tabelaPreco = tabelaPrecoRepository.findByVigencia(null);
		Tarifa tarifa = Tarifa.builder()
				.id(tabelaPreco.getId())
				.valorUnitario(tabelaPreco.getPrecoHora())
				.tabelaHoraPreco(tabelaPreco.getPrecosHora().stream().map(pe -> Preco.builder().hora(pe.getHora()).valor(pe.getValor()).build()).toList())
				.build();
		
		Pagamento pagamento = pagamentoGateway.findById(notificacaoPagamento.getSolicitacaoPagamentoId());
		
		RegistroEstacionamentoBase rEstacionamento = rEstacionamentoOp.get();
		rEstacionamento.setStatusPagamento(pagamento.getStatus());
		rEstacionamento.setTarifa(tarifa);
		rEstacionamento.setValorPago();
		rEstacionamento.setDeveNotificar(false);
		
		registroEstacionamentoRepositoryGateway.salvar(rEstacionamento);
	}
}
