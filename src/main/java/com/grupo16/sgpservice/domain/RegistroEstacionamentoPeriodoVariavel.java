package com.grupo16.sgpservice.domain;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
public class RegistroEstacionamentoPeriodoVariavel extends RegistroEstacionamentoBase {

	@Override
	public BigDecimal getValor() {
		LocalDateTime dataHoraFim = dataHoraTermino;
		
		if(dataHoraTermino == null) {
			dataHoraFim = LocalDateTime.now();//Verifica o preço da hora atual..
		}
		
		long totalHorasUtilizadas = Duration.between(dataHoraInicio, dataHoraFim).toHours();
		
		return tarifa.getValorPelaQuantidadeHoras(totalHorasUtilizadas);
	}
}
