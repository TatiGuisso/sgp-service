package com.grupo16.sgpservice.gateway.mongo.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.Veiculo;
import com.grupo16.sgpservice.gateway.VeiculoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VeiculoRepositoryGatewayImpl implements VeiculoRepositoryGateway{
	
	@Override
	public Optional<Veiculo> obter(String idVeiculo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public String salvar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	
}
