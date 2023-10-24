package com.grupo16.sgpservice.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Tarifa {
	private String id;
	private BigDecimal valorUnitario;//Hora
	private List<Preco> tabelaHoraPreco;
	
	public BigDecimal getPrecoHoraTabelada(Long hora) {
		return tabelaHoraPreco.stream().filter(p -> p.getHora().equals(hora)).findAny().get().getValor();
	}
			
	public BigDecimal getValorPelaQuantidadeHoras(Long quantidadeHora) {
		return new BigDecimal(quantidadeHora).multiply(valorUnitario);
	}
	
}
