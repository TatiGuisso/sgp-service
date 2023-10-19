package com.grupo16.sgpservice.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;

@Service
public class GetEstacionamentoUseCase {

	@Autowired
	private RegistroEstacionamentoRepositoryGateway estacionamentoRepositoryGateway;
	
	public RegistroEstacionamentoBase getById(String id) {
		return estacionamentoRepositoryGateway.getById(id);
	}
	
}
