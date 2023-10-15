package com.grupo16.sgpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.sgpservice.controller.json.CondutorJson;
import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.usecase.CriarAlterarCondutorUseCase;
import com.grupo16.sgpservice.usecase.ObterCondutorUseCase;
import com.grupo16.sgpservice.usecase.RemoverCondutorUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("condutores")
@RestController
public class CondutorController {
	
	@Autowired
	private CriarAlterarCondutorUseCase criarAlterarCondutorUseCase;

	@Autowired
	private ObterCondutorUseCase obterCondutorUseCase;

	@Autowired
	private RemoverCondutorUseCase removerCondutorUseCase;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public String criar(
			@RequestBody(required = true)CondutorJson condutorJson) {
		log.trace("Start condutorJson={}", condutorJson);
		
		Condutor condutor = condutorJson.parseCondutorDomain(null);
		
		String id = criarAlterarCondutorUseCase.criar(condutor);
		
		log.trace("End id={}", id);
		return id;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("{id}")
	public void alterar(
			@PathVariable(required = true, name = "id") String id,
			@RequestBody(required = true) CondutorJson condutorJson) {
		log.trace("Start id={}, condutorJson={}", id, condutorJson);
		
		Condutor condutor = condutorJson.parseCondutorDomain(id);
		
		criarAlterarCondutorUseCase.alterar(condutor);
		
		log.trace("End");
		
	}
	
	@GetMapping("{cpf}")
	public CondutorJson obter(
			@PathVariable(required = true, name = "cpf") String cpf) {
		log.trace("Start cpf={}", cpf);
		
		String cpfCondutor = removerMascara(cpf);
		
		Condutor condutor = obterCondutorUseCase.obterPorCpf(cpfCondutor);
		
		CondutorJson condutorJson = new CondutorJson(condutor);
		
		log.trace("End condutorJson={}", condutorJson);
		return condutorJson;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void remover(
			@PathVariable(required = true, name = "id") String id) {
		log.trace("Start id={}",id);
		
		removerCondutorUseCase.remover(id);
		log.trace("End");
	}
	
	private String removerMascara(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}

}
