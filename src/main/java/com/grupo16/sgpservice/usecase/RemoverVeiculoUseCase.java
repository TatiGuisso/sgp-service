package com.grupo16.sgpservice.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Veiculo;
import com.grupo16.sgpservice.gateway.VeiculoRepositoryGateway;

@Service
public class RemoverVeiculoUseCase {
	
	@Autowired
	private VeiculoRepositoryGateway veiculoRepositoryGateway;

	@Autowired
	private ObterVeiculoUseCase obterVeiculoUseCase;

	public void remover(String id) {
		
		Veiculo veiculo = obterVeiculoUseCase.obter(id);
		
		veiculoRepositoryGateway.remover(veiculo.getId());
	}

}
