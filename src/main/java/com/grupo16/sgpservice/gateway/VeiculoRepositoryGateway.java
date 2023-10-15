package com.grupo16.sgpservice.gateway;

import java.util.Optional;

import com.grupo16.sgpservice.domain.Veiculo;

public interface VeiculoRepositoryGateway {
	
	public Optional<Veiculo> obter(String idVeiculo);

	public String salvar(Veiculo veiculo);

	public void remover(String id);


}
