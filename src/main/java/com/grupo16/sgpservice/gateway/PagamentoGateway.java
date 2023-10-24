package com.grupo16.sgpservice.gateway;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;

public interface PagamentoGateway {

	public String solicitar(RegistroEstacionamentoBase registroEstacionamento);
	
}
