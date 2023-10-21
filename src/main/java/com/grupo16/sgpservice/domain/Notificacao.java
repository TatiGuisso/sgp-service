package com.grupo16.sgpservice.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Notificacao {
	private String id;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraExpiracao;
	private RegistroEstacionamentoBase registroEstacionamento;
}
