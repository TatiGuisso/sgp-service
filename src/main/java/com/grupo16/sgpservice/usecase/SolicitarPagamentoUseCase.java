package com.grupo16.sgpservice.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.gateway.PagamentoGateway;

@Service
public class SolicitarPagamentoUseCase {

	@Autowired
	private GetEstacionamentoUseCase getEstacionamentoUseCase;
	
	@Autowired
	private PagamentoGateway pagamentoGateway;
	
	public String solicitar(String idRegistroEstacionamento) {
		
		RegistroEstacionamentoBase rEstacionamento = getEstacionamentoUseCase.getById(idRegistroEstacionamento);
		
		return pagamentoGateway.solicitar(rEstacionamento);
	}
	
}
