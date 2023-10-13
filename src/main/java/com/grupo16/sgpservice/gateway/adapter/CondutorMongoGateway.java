package com.grupo16.sgpservice.gateway.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.gateway.CondutorRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CondutorMongoGateway implements CondutorRepositoryGateway{
	
	@Override
	public Optional<Condutor> obter(String cpf) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public String salvar(Condutor condutor) {
		// TODO Auto-generated method stub
		return null;
	}

}
