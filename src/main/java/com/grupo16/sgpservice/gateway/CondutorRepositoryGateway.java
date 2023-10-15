package com.grupo16.sgpservice.gateway;

import java.util.Optional;

import com.grupo16.sgpservice.domain.Condutor;

public interface CondutorRepositoryGateway {
	
	public Optional<Condutor> obterPorCpf(String cpf);

	public Optional<Condutor> obter(String id);

	public String salvar(Condutor condutor);


}
