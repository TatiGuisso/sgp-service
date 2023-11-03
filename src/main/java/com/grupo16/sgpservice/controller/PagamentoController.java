package com.grupo16.sgpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.sgpservice.controller.json.PagamentoTerceiroRequestJson;
import com.grupo16.sgpservice.domain.NotificacaoPagamento;
import com.grupo16.sgpservice.usecase.ProcessaNotificacaoPagamentoUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PagamentoController {
	
	@Autowired
	private ProcessaNotificacaoPagamentoUseCase processaNotificacaoPagamentoUseCase;
	
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
