package com.grupo16.sgpservice.gateway.mongo.document;

import com.grupo16.sgpservice.domain.Pagamento;
import com.grupo16.sgpservice.domain.StatusPagamento;

import lombok.Getter;

@Getter
public class PagamentoEntity {
	private String idSolicitacaoPagamento;
	private StatusPagamento status;
	private String sistemaPagamento;
	
	public PagamentoEntity(Pagamento pagamento) {
		idSolicitacaoPagamento = pagamento.getIdSolicitacaoPagamento();
		status = pagamento.getStatus();
		sistemaPagamento = pagamento.getSistemaPagamento();
	}
	
	public Pagamento getDomain() {
		return Pagamento.builder()
				.idSolicitacaoPagamento(idSolicitacaoPagamento)
				.status(status)
				.sistemaPagamento(sistemaPagamento)
				.build();
	}
	
}
