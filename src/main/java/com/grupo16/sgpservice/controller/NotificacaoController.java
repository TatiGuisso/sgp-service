package com.grupo16.sgpservice.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.sgpservice.usecase.NotificacaoUseCase;

@RestController
@RequestMapping("notificacoes")
public class NotificacaoController {
	
	@Autowired
	private NotificacaoUseCase notificacaoUseCase;
	
	@GetMapping
	public void get(
			@RequestParam(name = "dataInicio") LocalDateTime dataInicio,
			@RequestParam(name = "dataFim") LocalDateTime dataFim){
		
		//FIXME esse controler é temporário, está sendo usado somente para teste do fluxo.
		
		//notificacaoUseCase.notificar(dataInicio, dataFim);
		
	}

}
