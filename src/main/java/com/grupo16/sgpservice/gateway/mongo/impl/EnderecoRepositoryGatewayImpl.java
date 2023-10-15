package com.grupo16.sgpservice.gateway.mongo.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.Endereco;
import com.grupo16.sgpservice.exception.ErroAoAcessarBancoDadosException;
import com.grupo16.sgpservice.gateway.EnderecoRepositoryGateway;
import com.grupo16.sgpservice.gateway.mongo.document.EnderecoEntity;
import com.grupo16.sgpservice.gateway.mongo.repository.EnderecoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EnderecoRepositoryGatewayImpl implements EnderecoRepositoryGateway{

	@Autowired
	private EnderecoRepository enderecoRepository;


	@Override
	public String salvar(Endereco endereco) {
		try {
			
			EnderecoEntity enderecoDocument = new EnderecoEntity(endereco);
			
			enderecoRepository.save(enderecoDocument);
			
			return null;
		} catch (Exception e) {
			log.warn("Error to process. endereco={}", endereco);
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
	}

	@Override
	public Optional<Endereco> obter(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Endereco> obterPorCondutorId(String idCondutor) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	
}
