package com.grupo16.sgpservice.controller.json;

import com.grupo16.sgpservice.domain.Pagamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class PagamentoResponseJson {
	private String idSolicitacaoPagamento;
	private String status;
	private Double valorPago;
	
	public PagamentoResponseJson(Pagamento pagamento) {
		idSolicitacaoPagamento = pagamento.getIdSolicitacaoPagamento();
		status = pagamento.getStatus().toString();
		valorPago = pagamento.getValorPago();
	}
}
