package com.grupo16.sgpservice.gateway.mongo.document;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PrecoEntity {
	private Long hora;
	private BigDecimal valor;
}
