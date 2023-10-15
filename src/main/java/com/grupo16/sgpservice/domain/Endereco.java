package com.grupo16.sgpservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	private String id;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private Estado estado;
	private String cep;
//	private Condutor condutor;
}
