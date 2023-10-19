package com.grupo16.sgpservice.domain;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Tarifa {
	private String id;
	private BigDecimal valorUnitario;//Hora
	private Map<Integer, BigDecimal> tabelaHoraPreco;
	
	public BigDecimal getPrecoHoraTabelada(Integer hora) {
		return tabelaHoraPreco.get(hora);
	}
			
	public BigDecimal getValorPelaQuantidadeHoras(Long quantidadeHora) {
		return new BigDecimal(quantidadeHora).multiply(valorUnitario);
	}
	
}
