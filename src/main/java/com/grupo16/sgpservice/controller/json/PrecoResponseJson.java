package com.grupo16.sgpservice.controller.json;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;

import lombok.Getter;

@Getter
public class PrecoResponseJson {
	private String registroEstacionamentoId;
	private String veiculoId;
	private Double preco;
	
	public PrecoResponseJson(RegistroEstacionamentoBase domain) {
		registroEstacionamentoId = domain.getId();
		veiculoId = domain.getVeiculo().getId();
		preco = domain.getValor().doubleValue();
	}
	
}
