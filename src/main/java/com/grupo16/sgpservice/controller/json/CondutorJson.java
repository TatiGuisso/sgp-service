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
	private EnderecoJson endereco;

	public Condutor parseCondutorDomain(String idCondutor) {

		return  Condutor.builder()
				.id(idCondutor == null ? this.id : idCondutor)
				.nome(nome)
				.cpf(removerMascara(this.cpf))
				.email(email)
				.telefone(telefone)
				.endereco(this.endereco == null ? null : this.endereco.parseEnderecoDomain())
				.build();
	}

	public CondutorJson(Condutor condutor) {
		EnderecoJson enderecoJson = null;
		if(condutor.getEndereco() != null) {
			enderecoJson = new EnderecoJson(condutor.getEndereco());
		}

		this.id = condutor.getId();
		this.nome = condutor.getNome();
		this.cpf = condutor.getCpf();
		this.email = condutor.getEmail();
		this.telefone = condutor.getTelefone();
		this.endereco = enderecoJson;
	}

	private String removerMascara(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}

}
