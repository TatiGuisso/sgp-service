package com.grupo16.sgpservice.usecase.exception;

import com.grupo16.sgpservice.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class CondutorNaoEncontradoException extends SystemBaseException {
	private static final long serialVersionUID = 8430022812448133156L;
	
	private final String code = "sgp.condutorNaoEncontrado";
	private final String message = "Condutor não encontrado";
	private final Integer httpStatus = 404;
}
