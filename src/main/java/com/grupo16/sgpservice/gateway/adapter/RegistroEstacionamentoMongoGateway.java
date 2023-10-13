package com.grupo16.sgpservice.gateway.adapter;

import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.exception.ErroAcessoBancoDadosException;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegistroEstacionamentoMongoGateway implements RegistroEstacionamentoRepositoryGateway {

	@Override
	public String criar(RegistroEstacionamentoBase registroEstacionamentoBase) {
		try {
			
			//TODO: Implementar!
			
			return "any id";
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAcessoBancoDadosException();
		}
		
	}

}
