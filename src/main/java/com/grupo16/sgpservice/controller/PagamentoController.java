package com.grupo16.sgpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.sgpservice.controller.json.PagamentoResponseJson;
import com.grupo16.sgpservice.controller.json.PagamentoTerceiroRequestJson;
import com.grupo16.sgpservice.domain.NotificacaoPagamento;
import com.grupo16.sgpservice.usecase.ProcessaNotificacaoPagamentoUseCase;
import com.grupo16.sgpservice.usecase.SolicitarPagamentoUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PagamentoController {
	
	@Autowired
	private SolicitarPagamentoUseCase efetuarPagamentoUseCase;
	
	@Autowired
	private ProcessaNotificacaoPagamentoUseCase processaNotificacaoPagamentoUseCase;
	
	@PatchMapping("estacionamentos/{id}/solicitacao-pagamentos")
	public PagamentoResponseJson solicitarPagamento(@PathVariable("id") String estacionamentoId) {
		log.trace("Start estacionamentoId={}", estacionamentoId);
		
		final String idSolicitacaoPagamento = efetuarPagamentoUseCase.solicitar(estacionamentoId);
		
		PagamentoResponseJson pagamentoResponseJson = PagamentoResponseJson.builder()
				.idSolicitacaoPagamento(idSolicitacaoPagamento)
				.build();
		
		log.trace("End pagamentoResponseJson={}", pagamentoResponseJson);
		return pagamentoResponseJson;
	}
	
	/*
	 * Este método efetua o pagamento. 
	 * webhook - É chamado pelo sistema externo de pagamento (ex: mercado pago).
	 * Esta url fica cadastrada na conta do sistema de pagamento.
	 */
	@PostMapping("estacionamentos/{sistemaPagamento}/pagamentos")
	public void efetuar(
			@PathVariable("sistemaPagamento") String sistemaPagamento, 
			@RequestBody(required = true) PagamentoTerceiroRequestJson request) {
		log.trace("Start sistemaPagamento={}, request={}", sistemaPagamento, request);
		
		processaNotificacaoPagamentoUseCase.processa(NotificacaoPagamento.builder()
				.sistemaPagamento(sistemaPagamento)
				.solicitacaoPagamentoId(request.getId())
				.build());
		
		log.trace("End");
	}

}
