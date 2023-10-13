package com.grupo16.sgpservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.sgpservice.controller.json.CondutorJson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping()
@RestController
public class CondutorController {
	
	public String criar(
			@RequestBody(required=true)CondutorJson condutorJson) {
		log.trace("Start condutorJson={}", condutorJson);
		
		
		
//		log.trace("End id={}", id);
		return null;
	}

}
