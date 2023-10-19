package com.grupo16.sgpservice.domain;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
@Getter
public class RegistroEstacionamentoPeriodoFixo extends RegistroEstacionamentoBase {
	
	private Integer quantidadeHoras;

	@Override
	public BigDecimal getValor() {
		long totalHorasUtilizadas = Duration.between(dataHoraInicio, LocalDateTime.now()).toHours();
		
		BigDecimal valorQuantidadeHorasExcedidas = BigDecimal.ZERO;
		if(totalHorasUtilizadas > quantidadeHoras) {
			long horasExcedidas = totalHorasUtilizadas - quantidadeHoras;
			valorQuantidadeHorasExcedidas = tarifa.getValorPelaQuantidadeHoras(horasExcedidas);
		} 
		
		final BigDecimal precoHoraTabelada = tarifa.getPrecoHoraTabelada(quantidadeHoras);
		
		final BigDecimal custoTotal = precoHoraTabelada.add(valorQuantidadeHorasExcedidas);

		return custoTotal;
	}

	@Override
	public void iniciar() {
		super.iniciar();
		super.dataHoraTermino = dataHoraInicio.plusHours(quantidadeHoras);
	}
}
