package com.grupo16.sgpservice.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Veiculo;
import com.grupo16.sgpservice.gateway.VeiculoRepositoryGateway;

@Service
public class CriarAlterarVeiculoUseCase {
	
	@Autowired
	private VeiculoRepositoryGateway veiculoRepositoryGateway;

	@Autowired
	private ObterVeiculoUseCase obterVeiculoUseCase;


	public String criar(Veiculo veiculo) {
		return veiculoRepositoryGateway.salvar(veiculo);
	}

	public void alterar(Veiculo veiculo) {

		Veiculo veiculoEncontrado = obterVeiculoUseCase.obter(veiculo.getId());

		Veiculo veiculoSalvar = Veiculo.builder()
				.id(veiculoEncontrado.getId())
				.marca(veiculo.getMarca())
				.modelo(veiculo.getModelo())
				.placa(veiculo.getPlaca())
				.condutor(veiculo.getCondutor() == null ? null : veiculo.getCondutor())
				.build();

		veiculoRepositoryGateway.salvar(veiculoSalvar);
	}

}
