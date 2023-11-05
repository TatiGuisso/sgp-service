package com.grupo16.sgpservice.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Tarifa {
	private String id;
	private BigDecimal valorUnitario;//Hora
	private List<Preco> tabelaHoraPreco;
	
	public BigDecimal getPrecoHoraTabelada(Long hora) {
		Optional<Preco> precoOp = tabelaHoraPreco.stream().filter(p -> p.getHora().equals(hora)).findAny();
		
		if(precoOp.isPresent()) {
			return precoOp.get().getValor();
		}
		
		//Se não tiver o a hora na tabela, então considera a de maior valor.
		return tabelaHoraPreco.get(tabelaHoraPreco.size()-1).getValor();
	}
			
	public BigDecimal getValorPelaQuantidadeHoras(Long quantidadeHora) {
		if(quantidadeHora == 0L) {
			quantidadeHora = 1L;
		}
		return new BigDecimal(quantidadeHora).multiply(valorUnitario);
	}
	
}
