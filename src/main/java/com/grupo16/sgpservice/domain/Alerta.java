package com.grupo16.sgpservice.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Alerta {
	private String id;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraExpiracao;
	private RegistroEstacionamentoBase registroEstacionamento;
}
