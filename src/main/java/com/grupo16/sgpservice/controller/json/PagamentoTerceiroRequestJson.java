package com.grupo16.sgpservice.controller.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class PagamentoTerceiroRequestJson {
	private String id;
	private String statusSolicitacaoPagamento;
}
