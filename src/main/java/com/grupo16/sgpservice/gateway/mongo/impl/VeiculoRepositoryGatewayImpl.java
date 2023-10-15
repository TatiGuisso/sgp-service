package com.grupo16.sgpservice.gateway.mongo.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.Veiculo;
import com.grupo16.sgpservice.exception.ErroAoAcessarBancoDadosException;
import com.grupo16.sgpservice.gateway.VeiculoRepositoryGateway;
import com.grupo16.sgpservice.gateway.mongo.document.VeiculoDocument;
import com.grupo16.sgpservice.gateway.mongo.repository.VeiculoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VeiculoRepositoryGatewayImpl implements VeiculoRepositoryGateway{
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	
	@Override
	public String salvar(Veiculo veiculo) {
		
		try {
			return veiculoRepository.save(new VeiculoDocument(veiculo)).getId();
			
		} catch (Exception e) {
			log.warn("Error to process. veiculo={}", veiculo);
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
		
	}

	@Override
	public Optional<Veiculo> obter(String idVeiculo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	
}
