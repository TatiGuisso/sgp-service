package com.grupo16.sgpservice.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.sgpservice.domain.Pagamento;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@JsonInclude(Include.NON_NULL)
public class PagamentoJson {
	private String idSolicitacaoPagamento;
	private String sistemaPagamento;
	private String status;
	private Double valorPago;

	public PagamentoJson(Pagamento pagamento) {
		idSolicitacaoPagamento = pagamento.getIdSolicitacaoPagamento();
		sistemaPagamento = pagamento.getSistemaPagamento();
		status = pagamento.getStatus().name();
		valorPago = pagamento.getValorPago();
	}

	
}
