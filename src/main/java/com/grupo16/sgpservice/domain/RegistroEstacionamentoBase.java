package com.grupo16.sgpservice.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class RegistroEstacionamentoBase {
	private String id;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraTermino;
	
	private List<Alerta> alertas;
	private Veiculo veiculo;
	private Recibo recibo;
	
	public void iniciar() {
		dataHoraInicio = LocalDateTime.now();
	}
	
	public abstract BigDecimal getValor();
}
