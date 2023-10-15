package com.grupo16.sgpservice.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.gateway.CondutorRepositoryGateway;
import com.grupo16.sgpservice.usecase.exception.CpfJaCadastradoException;

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
			throw new CpfJaCadastradoException();
		}
		
		String id = condutorRepositoryGateway.salvar(condutor);
		
		return id;
	}

	public void alterar(Condutor condutor) {
		// TODO Auto-generated method stub
		
	}

}
