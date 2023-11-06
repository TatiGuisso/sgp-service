package com.grupo16.sgpservice.usecase.exception;

import com.grupo16.sgpservice.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class VeiculoNaoEncontradoException extends SystemBaseException {
	private static final long serialVersionUID = 5574461085232307312L;

	private final String code = "sgp.veiculoNaoEncontrado";
	private final String message = "Veiculo não encontrado";
	private final Integer httpStatus = 404;
}
