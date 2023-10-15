package com.grupo16.sgpservice.gateway.mongo.document.estacionamento;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@Document
public class VeiculoJson {
	
	@Id
	private String id;
}
