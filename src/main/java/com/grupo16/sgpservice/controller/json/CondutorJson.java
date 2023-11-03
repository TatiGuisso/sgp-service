package com.grupo16.sgpservice.controller.json;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.sgpservice.domain.Condutor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	
	@NotBlank
	private String nome;
	
	@NotNull
	@CPF
	private String cpf;
	
	@NotBlank
	private String email;
	
	@NotBlank
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
		this.id = condutor.getId();
		this.nome = condutor.getNome();
		this.cpf = condutor.getCpf();
		this.email = condutor.getEmail();
		this.telefone = condutor.getTelefone();
		this.endereco = condutor.getEndereco() == null ? null : new EnderecoJson(condutor.getEndereco());
	}

	private String removerMascara(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}

}
