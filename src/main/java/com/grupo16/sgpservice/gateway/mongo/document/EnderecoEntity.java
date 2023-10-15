package com.grupo16.sgpservice.gateway.mongo.document;

import com.grupo16.sgpservice.domain.Endereco;
import com.grupo16.sgpservice.domain.Estado;

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
public class EnderecoEntity {

	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	public EnderecoEntity(Endereco endereco) {
		rua = endereco.getRua();
		numero = endereco.getNumero();
		bairro = endereco.getBairro();
		cidade = endereco.getCidade();
		estado = endereco.getEstado().toString();
		cep = endereco.getCep();	
	}
	
	public Endereco parseEnderecoDomain() {
		return Endereco.builder()
				.rua(rua)
				.numero(numero)
				.bairro(bairro)
				.cidade(cidade)
				.estado(Estado.valueOf(estado))
				.cep(cep)
				.build();
	}
	
}
