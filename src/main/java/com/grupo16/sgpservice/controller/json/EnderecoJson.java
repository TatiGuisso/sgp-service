package com.grupo16.sgpservice.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.sgpservice.domain.Condutor;
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
	private String estado;
	private String cep;
//	private Condutor condutor;
	
	public Endereco parseEnderecoDomain() {
//		Condutor condutor = Condutor.builder()
//				.id(idCondutor == null ? this.condutor.getId() : idCondutor)
//				.build();
		
		return Endereco.builder()
//				.id(idEndereco == null ? this.id : idEndereco)
				.rua(rua)
				.numero(numero)
				.bairro(bairro)
				.cidade(cidade)
				.estado(Estado.valueOf(estado))
				.cep(cep)
//				.condutor(condutor)
				.build();
	}

	public EnderecoJson(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = String.valueOf(endereco.getEstado());
		this.cep = endereco.getCep();
//		this.condutor = Condutor.builder()
//				.id(endereco.getCondutor().getId())
//				.build();
	}

}
