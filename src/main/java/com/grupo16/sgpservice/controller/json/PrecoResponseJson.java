package com.grupo16.sgpservice.controller.json;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;

import lombok.Getter;

@Getter
public class PrecoResponseJson {
	private String registroEstacionamentoId;
	private Double precoEstacionamento;	
	private VeiculoJson veiculo;
	
	public PrecoResponseJson(RegistroEstacionamentoBase domain) {
		registroEstacionamentoId = domain.getId();
		precoEstacionamento = domain.getValor().doubleValue();
		veiculo = domain.getVeiculo() == null ? null : new VeiculoJson(domain.getVeiculo());
	}
	
}
