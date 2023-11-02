package com.grupo16.sgpservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class SolicitarPagamentoReturnDto {
	private String solicitacaoPagamentoId;
	private String sistemaPagamentoName;
	private String sistemaPagamentoUrl;
}
