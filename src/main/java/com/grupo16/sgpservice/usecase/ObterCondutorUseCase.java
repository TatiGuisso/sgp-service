package com.grupo16.sgpservice.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.gateway.CondutorRepositoryGateway;
import com.grupo16.sgpservice.usecase.exception.CondutorNaoEncontradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterCondutorUseCase {
	
	@Autowired
	private CondutorRepositoryGateway condutorRepositoryGateway;

	public Condutor obterPorCpf(String cpf) {
		
		Optional<Condutor> condutorOp = condutorRepositoryGateway.obterPorCpf(cpf);

		verificaSeFoiEncontrado(cpf, condutorOp);
		
		return condutorOp.get();
	}

	public Condutor obter(String id) {
		
		Optional<Condutor> condutorOp = condutorRepositoryGateway.obter(id);
		
		verificaSeFoiEncontrado(id, condutorOp);
		
		return condutorOp.get();
	}

	private void verificaSeFoiEncontrado(String identificador, Optional<Condutor> condutorOp) {
		if(condutorOp.isEmpty()) {
			log.warn("Condutor não encontrado. id/cpf={}", identificador);
			throw new CondutorNaoEncontradoException();
		}
	}

}
