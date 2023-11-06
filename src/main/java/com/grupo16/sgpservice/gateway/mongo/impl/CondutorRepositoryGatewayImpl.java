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
public class CondutorRepositoryGatewayImpl implements CondutorRepositoryGateway{

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
	public Optional<Condutor> obterPorCpf(String cpf) {
		try {
			Optional<CondutorDocument> condutorDocOp = condutorRepository.findByCpf(cpf);

			return checarSeExisteEMapearParaDomain(condutorDocOp);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
	}

	@Override
	public Optional<Condutor> obter(String id) {
		try {
			Optional<CondutorDocument> condutorDocOp = condutorRepository.findById(id);

			return checarSeExisteEMapearParaDomain(condutorDocOp);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
	}

	@Override
	public void remover(String id) {
		try {
			condutorRepository.deleteById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDadosException();
		}
	}

	private Optional<Condutor> checarSeExisteEMapearParaDomain(Optional<CondutorDocument> condutorDocOp) {
		Optional<Condutor> condutorOptional = Optional.empty();
		if(condutorDocOp.isEmpty()) {
			return condutorOptional;
		}
		condutorOptional = Optional.of(condutorDocOp.get().parseCondutorDomain());
		return condutorOptional;
	}


}
