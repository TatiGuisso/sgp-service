package com.grupo16.sgpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.sgpservice.controller.json.CondutorJson;
import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.usecase.CriarAlterarCondutorUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("condutores")
@RestController
public class CondutorController {
	
	@Autowired
	private CriarAlterarCondutorUseCase criarAlterarCondutorUseCase;
	
	public String criar(
			@RequestBody(required = true)CondutorJson condutorJson) {
		log.trace("Start condutorJson={}", condutorJson);
		
		Condutor condutor = condutorJson.mapearParaCondutorDomain();
		
		String id = criarAlterarCondutorUseCase.criar(condutor);
		
		log.trace("End id={}", id);
		return id;
	}
	
	@PutMapping("{id}")
	public void alterar(
			@PathVariable(required = true, name = "id") String id,
			@RequestBody(required = true) CondutorJson condutorJson) {
		log.trace("Start id={}, condutorJson={}", id, condutorJson);
		
		Condutor condutor = condutorJson.mapearParaCondutorDomain();
		
		criarAlterarCondutorUseCase.alterar(condutor);
		
		log.trace("End");
		
	}

}
