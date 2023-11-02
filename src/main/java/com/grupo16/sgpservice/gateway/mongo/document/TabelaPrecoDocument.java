package com.grupo16.sgpservice.gateway.mongo.document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TabelaPrecoDocument {
	
	@Id
	private String id;
	private LocalDate vigencia;
	private BigDecimal precoHora;//Estacionamento de tempo variavel.
	private List<PrecoEntity> precosHora;//Estacionamento de tempo fixo.

}
