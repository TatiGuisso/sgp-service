package com.grupo16.sgpservice.domain;

import java.util.List;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class RegistroEstacionamentoBase {
	private String id;
	private List<Alerta> alertas;
	private Veiculo veiculo;
	private Recibo recibo;
}
