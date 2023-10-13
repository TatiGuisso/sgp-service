package com.grupo16.sgpservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Endereco {

	private String id;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private Estado estado;
	private String cep;

}
