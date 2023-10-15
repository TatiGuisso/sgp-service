package com.grupo16.sgpservice.gateway.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.exception.ErroAcessoBancoDadosException;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;
import com.grupo16.sgpservice.gateway.mongo.document.estacionamento.RegistroEstacionamentoDocument;
import com.grupo16.sgpservice.gateway.mongo.repository.RegistroEstacionamentoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegistroEstacionamentoGatewayImpl implements RegistroEstacionamentoRepositoryGateway {

	@Autowired
	private RegistroEstacionamentoRepository registroEstacionamentoRepository;
	
	@Override
	public String criar(RegistroEstacionamentoBase registroEstacionamento) {
		try {
			return registroEstacionamentoRepository.save(new RegistroEstacionamentoDocument(registroEstacionamento)).getId();
			
		} catch (Exception e) {
			log.warn("Error to process. registroEstacionamentoBase={}", registroEstacionamento);
			log.error(e.getMessage(), e);
			throw new ErroAcessoBancoDadosException();
		}
		
	}

}
