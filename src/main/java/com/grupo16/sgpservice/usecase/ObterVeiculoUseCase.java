package com.grupo16.sgpservice.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Veiculo;
import com.grupo16.sgpservice.gateway.VeiculoRepositoryGateway;
import com.grupo16.sgpservice.usecase.exception.VeiculoNaoEncontradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterVeiculoUseCase {
	
	@Autowired
	private VeiculoRepositoryGateway veiculoRepositoryGateway;

	public Veiculo obter(String idVeiculo) {
		
		Optional<Veiculo> veiculoOp = veiculoRepositoryGateway.obter(idVeiculo);

		if(veiculoOp.isEmpty()) {
			log.warn("Veículo não encontrado. idVeiculo={}", idVeiculo);
			throw new VeiculoNaoEncontradoException();
		}
		
		return veiculoOp.get();
	}

}
