package com.grupo16.sgpservice.domain;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Preco {
	private Long hora;
	private BigDecimal valor;
}
