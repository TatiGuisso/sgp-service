package com.grupo16.sgpservice.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.NotificacaoPagamento;
import com.grupo16.sgpservice.domain.Pagamento;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.gateway.PagamentoGateway;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessaNotificacaoPagamentoUseCase {

	@Autowired
	private RegistroEstacionamentoRepositoryGateway registroEstacionamentoRepositoryGateway;
	
	@Autowired
	private PagamentoGateway pagamentoGateway;
	
	public void processa(NotificacaoPagamento notificacaoPagamento) {
		
		Optional<RegistroEstacionamentoBase> rEstacionamentoOp = registroEstacionamentoRepositoryGateway.getBySolicitacaoPagamento(notificacaoPagamento.getSolicitacaoPagamentoId());
		
		if(rEstacionamentoOp.isEmpty()) {
			log.warn("Solicitação de pagamento não encontrada no sistema! Ignorando...");
			return;
		}
		
		Pagamento pagamento = pagamentoGateway.findById(notificacaoPagamento.getSolicitacaoPagamentoId());
		
		RegistroEstacionamentoBase rEstacionamento = rEstacionamentoOp.get();
		rEstacionamento.setStatusPagamento(pagamento.getStatus());
		registroEstacionamentoRepositoryGateway.salvar(rEstacionamento);
	}
}
