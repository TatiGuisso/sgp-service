package com.grupo16.sgpservice.domain;

import java.math.BigDecimal;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
public class RegistroEstacionamentoPeriodoFixo extends RegistroEstacionamentoBase {
	//TODO - implementar
	
	private Integer quantidadeHoras;

	@Override
	public BigDecimal getValor() {
		// TODO Auto-generated method stub
		return null;
	}

}
