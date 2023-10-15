package com.grupo16.sgpservice.gateway.mongo.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.exception.ErroAoAcessarBancoDadosException;
import com.grupo16.sgpservice.gateway.CondutorRepositoryGateway;
import com.grupo16.sgpservice.gateway.mongo.document.CondutorDocument;
import com.grupo16.sgpservice.gateway.mongo.repository.CondutorRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CondutorGatewayImpl implements CondutorRepositoryGateway{
	
	@Autowired
	private CondutorRepository condutorRepository;
	
	@Override
	public String salvar(Condutor condutor) {
		
		try {
			return condutorRepository.save(new CondutorDocument(condutor)).getId();
			
		} catch (Exception e) {
			log.warn("Error to process. condutor={}", condutor);
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}		
	}

	@Override
	public Optional<Condutor> obter(String cpf) {
		try {
			Optional<Condutor> condutorOptional = Optional.empty();
			Optional<CondutorDocument> condutorDocOp = condutorRepository.findByCpf(cpf);
			
			if(condutorDocOp.isEmpty()) {
				return condutorOptional;
			}
			
			condutorOptional = Optional.of(condutorDocOp.get().mapearParaDomain());
			
			return condutorOptional;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
	}


}
