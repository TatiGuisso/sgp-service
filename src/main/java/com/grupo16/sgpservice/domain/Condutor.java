package com.grupo16.sgpservice.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Condutor {
	
	private String id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private List<Veiculo> veiculos;
	private List<FormaPagamentoBase> formasPagamentos;
	private Endereco endereco;
}
