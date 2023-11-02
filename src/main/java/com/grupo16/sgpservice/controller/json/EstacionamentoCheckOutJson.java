package com.grupo16.sgpservice.controller.json;

import com.grupo16.sgpservice.dto.SolicitarPagamentoReturnDto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EstacionamentoCheckOutJson {
	private String solicitacaoPagamentoId;
	private String sistemaPagamentoName;
	private String sistemaPagamentoUrl;
	
	public EstacionamentoCheckOutJson(SolicitarPagamentoReturnDto dto) {
		solicitacaoPagamentoId = dto.getSolicitacaoPagamentoId();
		sistemaPagamentoName = dto.getSistemaPagamentoName();
		sistemaPagamentoUrl = dto.getSistemaPagamentoUrl();
	}

}
