package com.grupo16.sgpservice.gateway.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo16.sgpservice.gateway.mongo.document.estacionamento.RegistroEstacionamentoDocument;

public interface RegistroEstacionamentoRepository extends MongoRepository<RegistroEstacionamentoDocument, String>{

}
