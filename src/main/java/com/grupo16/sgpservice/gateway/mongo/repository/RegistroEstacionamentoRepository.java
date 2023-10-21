package com.grupo16.sgpservice.gateway.mongo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo16.sgpservice.gateway.mongo.document.RegistroEstacionamentoDocument;

public interface RegistroEstacionamentoRepository extends MongoRepository<RegistroEstacionamentoDocument, String>{
	
	public List<RegistroEstacionamentoDocument> findByDataHoraTerminoBetween(LocalDateTime dataHoraIncio, LocalDateTime dataHoraTermino);

	
	
}
