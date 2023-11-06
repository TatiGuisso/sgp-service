package com.grupo16.sgpservice.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FormaPagamentoBase {
	private String id;
	private Condutor condutor;
}
