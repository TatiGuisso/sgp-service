package com.grupo16.sgpservice.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Veiculo {
	private String id;
	private String modelo;
	private String placa;
	private Condutor condutor;
	private List<RegistroEstacionamentoBase> registrosPagamento;
}
