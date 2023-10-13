package com.grupo16.sgpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.sgpservice.controller.json.EnderecoJson;
import com.grupo16.sgpservice.domain.Endereco;
import com.grupo16.sgpservice.usecase.CriarEnderecoUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("enderecos")
public class EnderecoController {
	
	@Autowired
	private CriarEnderecoUseCase criarEnderecoUseCase;

	@PostMapping
	public String criar(
			@RequestBody(required = true) EnderecoJson enderecoJson) {
		log.trace("Start enderecoJson={}", enderecoJson);
		
		Endereco endereco = enderecoJson.mapearParaEnderecoDomain();
		
		String id = criarEnderecoUseCase.criar(endereco);
				
		log.trace("End id={}", id);
		return id;
	}
	
}
