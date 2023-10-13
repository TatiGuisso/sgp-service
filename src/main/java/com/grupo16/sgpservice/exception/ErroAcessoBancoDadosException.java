package com.grupo16.sgpservice.exception;

import lombok.Getter;

@Getter
public class ErroAcessoBancoDadosException extends SystemBaseException {
	private static final long serialVersionUID = -415384055723475621L;
	
	private final String code = "sgp.erroAoAcessarBancoDados";
	private final String message = "Erro ao acessar o banco de dados";
	private final Integer httpStatus = 500;
}
