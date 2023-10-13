package com.grupo16.sgpservice.controller.json;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoPeriodoFixo;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoPeriodoVariavel;
import com.grupo16.sgpservice.domain.TipoEstacionamento;
import com.grupo16.sgpservice.domain.Veiculo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EstacionamentoCheckInJson {
	private String id;
	private Integer quantidadeHoras;
	private String veiculoId;
	private TipoEstacionamento tipoEstacionamento;
	
	public RegistroEstacionamentoBase parseDomain() {
		
		RegistroEstacionamentoBase registroEstacionamento = null;
		
		Veiculo veiculo = Veiculo.builder().id(veiculoId).build();
		
		if(TipoEstacionamento.TEMPO_FIXO.equals(tipoEstacionamento)) {
			
			registroEstacionamento = RegistroEstacionamentoPeriodoFixo.builder()
				.id(id)
				.quantidadeHoras(quantidadeHoras)
				.veiculo(veiculo)
			.build();
			
		} else {
			registroEstacionamento = RegistroEstacionamentoPeriodoVariavel.builder()
					.id(id)
					.veiculo(veiculo)
					.build();
		}
		
		return registroEstacionamento;
	}
	
}
