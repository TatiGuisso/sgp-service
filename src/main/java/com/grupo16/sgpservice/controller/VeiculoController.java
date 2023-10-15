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

import com.grupo16.sgpservice.controller.json.VeiculoJson;
import com.grupo16.sgpservice.domain.Veiculo;
import com.grupo16.sgpservice.usecase.CriarAlterarVeiculoUseCase;
import com.grupo16.sgpservice.usecase.ObterVeiculoUseCase;
import com.grupo16.sgpservice.usecase.RemoverVeiculoUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("veiculos")
@RestController
public class VeiculoController {
	
	@Autowired
	private CriarAlterarVeiculoUseCase criarAlterarVeiculoUseCase;

	@Autowired
	private ObterVeiculoUseCase obterVeiculoUseCase;

	@Autowired
	private RemoverVeiculoUseCase removerVeiculoUseCase;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public String criar(
			@RequestBody(required = true)VeiculoJson veiculoJson) {
		log.trace("Start condutorJson={}", veiculoJson);
		
		Veiculo veiculo = veiculoJson.parseVeiculoDomain(null);
		
		String id = criarAlterarVeiculoUseCase.criar(veiculo);
		
		log.trace("End id={}", id);
		return id;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("{id}")
	public void alterar(
			@PathVariable(required = true, name = "id") String idVeiculo,
			@RequestBody(required = true) VeiculoJson veiculoJson) {
		log.trace("Start idVeiculo={}, veiculoJson={}", idVeiculo, veiculoJson);
		
		Veiculo veiculo = veiculoJson.parseVeiculoDomain(idVeiculo);
		
		criarAlterarVeiculoUseCase.alterar(veiculo);
		
		log.trace("End");
		
	}
	
	@GetMapping("{idVeiculo}")
	public VeiculoJson obter(
			@PathVariable(required = true, name = "idVeiculo") String idVeiculo) {
		log.trace("Start idVeiculo={}", idVeiculo);
		
		Veiculo veiculo = obterVeiculoUseCase.obter(idVeiculo);
		
		VeiculoJson veiculoJson = new VeiculoJson(veiculo);
		
		log.trace("End veiculoJson={}", veiculoJson);
		return veiculoJson;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void remover(
			@PathVariable(required = true, name = "id") String id) {
		log.trace("Start id={}",id);
		
		removerVeiculoUseCase.remover(id);
		log.trace("End");
	}
	
}
