package com.grupo16.sgpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.sgpservice.controller.json.PagamentoResponseJson;
import com.grupo16.sgpservice.usecase.SolicitarPagamentoUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PagamentoController {
	
	@Autowired
	private SolicitarPagamentoUseCase efetuarPagamentoUseCase;
	
	@PostMapping("estacionamentos/{id}/pagamentos")
	public PagamentoResponseJson efetuar(@PathVariable("id") String estacionamentoId) {
		log.trace("Start estacionamentoId={}", estacionamentoId);
		
		final String idSolicitacaoPagamento = efetuarPagamentoUseCase.solicitar(estacionamentoId);
		
		PagamentoResponseJson pagamentoResponseJson = new PagamentoResponseJson(idSolicitacaoPagamento);
		
		log.trace("End pagamentoResponseJson={}", pagamentoResponseJson);
		return pagamentoResponseJson;
	}

}
