package com.grupo16.sgpservice.gateway.mongo.impl.exception;

import com.grupo16.sgpservice.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class RegistroEstacionamentoNaoEncontradoException extends SystemBaseException {
	private static final long serialVersionUID = 8430022812448133156L;
	
	private final String code = "sgp.registroEstacionamentoNaoEncontrado";
	private final String message = "Registro de estacionamento não encontrado";
	private final Integer httpStatus = 404;
}
