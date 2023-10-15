package com.grupo16.sgpservice.usecase.exception;

import com.grupo16.sgpservice.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class CpfJaCadastradoException extends SystemBaseException {
	private static final long serialVersionUID = -91865358690395984L;
	
	private final String code = "sgp.cpfJaCadastrado";
	private final String message = "CPF já cadastrado";
	private final Integer httpStatus = 422;
}
