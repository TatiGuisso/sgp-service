package com.grupo16.sgpservice.domain;

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
	private RegistroEstacionamentoBase registroEstacionamento;
}
