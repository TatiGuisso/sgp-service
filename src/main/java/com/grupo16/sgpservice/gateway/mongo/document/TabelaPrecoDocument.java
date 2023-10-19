package com.grupo16.sgpservice.gateway.mongo.document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.annotation.Id;

import lombok.Getter;

@Getter
public class TabelaPrecoDocument {
	
	@Id
	private String id;
	private LocalDate vigencia;
	private BigDecimal precoHora;//Estacionamento de tempo variavel.
	private Map<Integer, BigDecimal> precosHora;//Estacionamento de tempo fixo.

}
