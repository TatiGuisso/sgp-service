package com.grupo16.sgpservice.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotificacaoPagamento {
	private String solicitacaoPagamentoId;
	private String statusSolicitacaoPagamento;
	private String sistemaPagamento;
}
