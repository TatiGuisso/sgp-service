package com.grupo16.sgpservice.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.sgpservice.domain.Endereco;
import com.grupo16.sgpservice.domain.Estado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EnderecoJson {
	
	private String id;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private Estado estado;
	private String cep;
	
	public Endereco mapearParaEnderecoDomain() {
		// TODO Auto-generated method stub
		return null;
	}

}
