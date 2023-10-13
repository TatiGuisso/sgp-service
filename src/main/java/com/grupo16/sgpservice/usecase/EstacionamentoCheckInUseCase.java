package com.grupo16.sgpservice.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;

@Service
public class EstacionamentoCheckInUseCase {

	@Autowired
	private RegistroEstacionamentoRepositoryGateway estacionamentoRepositoryGateway;
	
	public String ckeckIn(RegistroEstacionamentoBase registroEstacionamento) {
		registroEstacionamento.iniciar();
		return estacionamentoRepositoryGateway.criar(registroEstacionamento);
	}
	
}
