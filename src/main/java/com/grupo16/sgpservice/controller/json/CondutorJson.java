package com.grupo16.sgpservice.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.domain.Endereco;

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
	private Endereco endereco;
	
	public Condutor mapearParaCondutorDomain(String id) {
		return  Condutor.builder()
				.id(id == null ? this.id : id)
				.nome(nome)
				.cpf(removerMascara(this.cpf))
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
	
	private String removerMascara(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}
	
}
