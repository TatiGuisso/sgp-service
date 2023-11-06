package com.grupo16.sgpservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Pagamento {
	private String idSolicitacaoPagamento;
	private String sistemaPagamento;
	
	@Setter
	private StatusPagamento status;
	
	@Setter	
	private Double valorPago;
}
