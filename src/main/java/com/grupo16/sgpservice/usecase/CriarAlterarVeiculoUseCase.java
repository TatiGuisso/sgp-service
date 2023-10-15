package com.grupo16.sgpservice.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Veiculo;
import com.grupo16.sgpservice.gateway.VeiculoRepositoryGateway;

@Service
public class CriarAlterarVeiculoUseCase {
	
	@Autowired
	private VeiculoRepositoryGateway veiculoRepositoryGateway;

	public String criar(Veiculo veiculo) {
		return veiculoRepositoryGateway.salvar(veiculo);
	}

	public void alterar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
	}

}
