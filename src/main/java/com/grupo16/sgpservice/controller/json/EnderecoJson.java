package com.grupo16.sgpservice.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.sgpservice.domain.Endereco;

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
	private String estado;
	private String cep;
	
	public Endereco mapearParaEnderecoDomain(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public EnderecoJson(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = String.valueOf(endereco.getEstado());
		this.cep = endereco.getCep();
	}

}
