package com.grupo16.sgpservice.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.gateway.CondutorRepositoryGateway;

@Service
public class RemoverCondutorUseCase {
	
	@Autowired
	private CondutorRepositoryGateway condutorRepositoryGateway;

	@Autowired
	private ObterCondutorUseCase obterCondutorUseCase;

	public void remover(String id) {
		
		Condutor condutor = obterCondutorUseCase.obter(id);
		
		condutorRepositoryGateway.remover(condutor.getId());
		
	}

}
