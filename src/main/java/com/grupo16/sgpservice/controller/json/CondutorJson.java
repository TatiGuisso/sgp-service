package com.grupo16.sgpservice.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.sgpservice.domain.Condutor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CondutorJson {

	private String id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	
	public Condutor mapearParaCondutorDomain() {
		return  Condutor.builder()
				.nome(nome)
				.cpf(cpf)
				.email(email)
				.telefone(telefone)
				.build();
	}

	public CondutorJson(Condutor condutor) {
		this.id = condutor.getId();
		this.nome = condutor.getNome();
		this.cpf = condutor.getCpf();
		this.email = condutor.getEmail();
		this.telefone = condutor.getTelefone();
	}
	
}
