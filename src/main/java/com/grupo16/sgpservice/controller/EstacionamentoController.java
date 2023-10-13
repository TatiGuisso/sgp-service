package com.grupo16.sgpservice.controller;

import com.grupo16.sgpservice.controller.json.EstacionamentoCheckInJson;
import com.grupo16.sgpservice.usecase.EstacionamentoCheckInUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EstacionamentoController {
	
	private EstacionamentoCheckInUseCase estacionamentoCheckInUseCase;
	
	public String checkIn(EstacionamentoCheckInJson json) {
		log.trace("Start json={}", json);
		
		String ckeckInId = estacionamentoCheckInUseCase.ckeckIn(json.parseDomain());
		
		log.trace("End ckeckInId={}", ckeckInId);
		return ckeckInId;
	}
}
