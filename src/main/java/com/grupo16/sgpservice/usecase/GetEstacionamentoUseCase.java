package com.grupo16.sgpservice.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;
import com.grupo16.sgpservice.gateway.mongo.impl.exception.RegistroEstacionamentoNaoEncontradoException;

@Service
public class GetEstacionamentoUseCase {

	@Autowired
	private RegistroEstacionamentoRepositoryGateway estacionamentoRepositoryGateway;
	
	public RegistroEstacionamentoBase getById(String id) {
		return estacionamentoRepositoryGateway.getById(id);
	}
	
	public RegistroEstacionamentoBase getByIdAndPagamentoStatus(String id, String status) {
		Optional<RegistroEstacionamentoBase> reOptional = estacionamentoRepositoryGateway.getByIdAndPagamentoStatus(id, status);
		
		if(reOptional.isEmpty()) {
			throw new RegistroEstacionamentoNaoEncontradoException();
		}
		
		RegistroEstacionamentoBase re = reOptional.get();
		
		return re;		
	}
	
}
