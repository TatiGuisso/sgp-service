package com.grupo16.sgpservice.gateway;

import java.util.Optional;

import com.grupo16.sgpservice.domain.Condutor;

public interface CondutorRepositoryGateway {
	
	public Optional<Condutor> obter(String cpf);

	public String salvar(Condutor condutor);

}
