package com.grupo16.sgpservice.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.domain.Endereco;
import com.grupo16.sgpservice.gateway.CondutorRepositoryGateway;
import com.grupo16.sgpservice.usecase.exception.CpfJaCadastradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriarAlterarCondutorUseCase {

	@Autowired
	private CondutorRepositoryGateway condutorRepositoryGateway;
	
	@Autowired
	private ObterCondutorUseCase obterCondutorUseCase;
	
	public String criar(Condutor condutor) {
		
		Optional<Condutor> condutorOp = condutorRepositoryGateway.obterPorCpf(condutor.getCpf());
		if(condutorOp.isPresent()) {
			log.warn("CPF já cadastrado: {}", condutor.getCpf());
			throw new CpfJaCadastradoException();
		}
		
		return condutorRepositoryGateway.salvar(condutor);
	}

	public void alterar(Condutor condutor) {
		
		Condutor condutorEncontrado = obterCondutorUseCase.obter(condutor.getId());
		
		Condutor condutorSalvar = Condutor.builder()
				.id(condutorEncontrado.getId())
				.nome(condutor.getNome())
				.cpf(condutorEncontrado.getCpf())
				.email(condutor.getEmail())
				.telefone(condutor.getTelefone())
				.endereco(condutor.getEndereco() == null ? null : condutor.getEndereco())
				.build();
		
		condutorRepositoryGateway.salvar(condutorSalvar);
	}

}
