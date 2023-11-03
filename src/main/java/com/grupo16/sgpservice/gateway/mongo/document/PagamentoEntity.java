package com.grupo16.sgpservice.gateway.mongo.document;

import com.grupo16.sgpservice.domain.Pagamento;
import com.grupo16.sgpservice.domain.StatusPagamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PagamentoEntity {
	private String idSolicitacaoPagamento;
	private StatusPagamento status;
	private String sistemaPagamento;
	private Double valorPago;
	
	public PagamentoEntity(Pagamento pagamento) {
		idSolicitacaoPagamento = pagamento.getIdSolicitacaoPagamento();
		status = pagamento.getStatus();
		sistemaPagamento = pagamento.getSistemaPagamento();
		valorPago = pagamento.getValorPago();
	}
	
	public Pagamento getDomain() {
		return Pagamento.builder()
				.idSolicitacaoPagamento(idSolicitacaoPagamento)
				.status(status)
				.sistemaPagamento(sistemaPagamento)
				.valorPago(valorPago)
				.build();
	}
	
}
