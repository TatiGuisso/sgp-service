package com.grupo16.sgpservice.gateway.mock;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.Pagamento;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.domain.StatusPagamento;
import com.grupo16.sgpservice.dto.SolicitarPagamentoReturnDto;
import com.grupo16.sgpservice.gateway.PagamentoGateway;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PagamentoMockGateway implements PagamentoGateway {

	@Override
	public SolicitarPagamentoReturnDto solicitar(RegistroEstacionamentoBase registroEstacionamento) {
		
		/*
		 * Esta classe (adapter) representa um mock de pagamento (fins didáticos). 
		 * Na pratica implementar uma classe (adpter) qual chama um mercado pago por exemplo
		 * 
		 */
		
		log.warn("### MOCK DE PAGAMENTO ###");
		
		final String solicitacaoPagamentoId = UUID.randomUUID().toString();
		
		return SolicitarPagamentoReturnDto.builder()
				.solicitacaoPagamentoId(solicitacaoPagamentoId)
				.sistemaPagamentoName("MOCK")
				.sistemaPagamentoUrl("https://mock/iniciar-pagamento/" + solicitacaoPagamentoId)
				.build();
	}

	@Override
	public Pagamento findById(String solicitacaoPagamentoId) {
		log.warn("### MOCK DE PAGAMENTO ###");

		return Pagamento.builder().idSolicitacaoPagamento(solicitacaoPagamentoId)
				.status(StatusPagamento.PAGO)
				.sistemaPagamento("MOCK")
				.build();
	}

}
