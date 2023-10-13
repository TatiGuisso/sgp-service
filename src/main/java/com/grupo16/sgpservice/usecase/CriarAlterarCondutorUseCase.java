package com.grupo16.sgpservice.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.gateway.CondutorRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriarAlterarCondutorUseCase {

	@Autowired
	private CondutorRepositoryGateway condutorRepositoryGateway;
	
	public String criar(Condutor condutor) {
		
		Optional<Condutor> condutorOp = condutorRepositoryGateway.obter(condutor.getCpf());
		if(condutorOp.isPresent()) {
			log.warn("CPF já cadastrado: {}", condutor.getCpf());
			//TODO implementar exception. Condutor já cadastrado.
		}
		
		String id = condutorRepositoryGateway.salvar(condutor);
		
		return null;
	}

	public void alterar(Condutor condutor) {
		// TODO Auto-generated method stub
		
	}

}
