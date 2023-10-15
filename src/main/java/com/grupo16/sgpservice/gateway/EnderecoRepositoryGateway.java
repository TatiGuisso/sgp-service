package com.grupo16.sgpservice.gateway;

import java.util.Optional;

import com.grupo16.sgpservice.domain.Endereco;

public interface EnderecoRepositoryGateway {
	
	public Optional<Endereco> obter(String id);

	public String salvar(Endereco endereco);

	public void remover(String id);

	public Optional<Endereco> obterPorCondutorId(String idCondutor);

}
