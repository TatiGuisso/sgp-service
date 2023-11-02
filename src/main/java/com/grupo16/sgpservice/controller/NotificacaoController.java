package com.grupo16.sgpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.sgpservice.usecase.NotificacaoUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("notificacoes")
@RestController
public class NotificacaoController {
	
	@Autowired
	private NotificacaoUseCase notificacaoUseCase;
	
	@PatchMapping()
	public void notificar() {
		log.trace("Start");
		
		notificacaoUseCase.notificar();
		
		log.trace("End");
	}
	
}
