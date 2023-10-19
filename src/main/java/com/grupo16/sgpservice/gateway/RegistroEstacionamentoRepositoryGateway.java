package com.grupo16.sgpservice.gateway;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;

public interface RegistroEstacionamentoRepositoryGateway {
	
	String criar(RegistroEstacionamentoBase registroEstacionamentoBase);

	RegistroEstacionamentoBase getById(String id);
	

}
