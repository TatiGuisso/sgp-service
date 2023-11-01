package com.grupo16.sgpservice.controller.json;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;

import lombok.Getter;

@Getter
public class ReciboJson {
	
	private String registroEstacionamentoId;
	private PagamentoResponseJson pagamento;
	private VeiculoJson veiculo;
	
	public ReciboJson(RegistroEstacionamentoBase re) {
		registroEstacionamentoId = re.getId();
		veiculo = re.getVeiculo() == null ? null : new VeiculoJson(re.getVeiculo());
		pagamento = re.getPagamento() == null ? null : new PagamentoResponseJson(re.getPagamento());
	}

}
