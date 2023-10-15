package com.grupo16.sgpservice.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Endereco;
import com.grupo16.sgpservice.gateway.EnderecoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriarAlterarEnderecoUseCase {

	@Autowired
	private EnderecoRepositoryGateway enderecoRepositoryGateway;

	public String criar(Endereco endereco) {
		
		//o condutor já possui um endereço cadastrado. Caso deseje alterá-lo, por favor escolher a opção correta. 
		
		String idCondutor = endereco.getCondutor().getId() == null ? null : endereco.getCondutor().getId(); 
		
		Optional<Endereco> enderecoOp = enderecoRepositoryGateway.obterPorCondutorId(idCondutor);
		
		if(enderecoOp.isPresent()) {
			log.warn("");
		}
		
		enderecoRepositoryGateway.salvar(endereco);

		return null;

	}

	public void alterar(Endereco endereco) {
		// TODO Auto-generated method stub

	}

}
