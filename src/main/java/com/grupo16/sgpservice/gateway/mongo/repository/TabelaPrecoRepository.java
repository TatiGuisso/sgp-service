package com.grupo16.sgpservice.gateway.mongo.repository;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo16.sgpservice.gateway.mongo.document.TabelaPrecoDocument;

public interface TabelaPrecoRepository extends MongoRepository<TabelaPrecoDocument, String>{

	TabelaPrecoDocument findByVigencia(LocalDate vigencia);

}
