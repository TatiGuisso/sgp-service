package com.grupo16.sgpservice.gateway.mongo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo16.sgpservice.gateway.mongo.document.RegistroEstacionamentoDocument;

public interface RegistroEstacionamentoRepository extends MongoRepository<RegistroEstacionamentoDocument, String>{
	
	public List<RegistroEstacionamentoDocument> findByDeveNotificarAndDataHoraPrevisaoNotificacaoBetween(
			Boolean notifica, LocalDateTime dataHoraIncio, LocalDateTime dataHoraTermino);

	public Optional<RegistroEstacionamentoDocument> findByPagamentoIdSolicitacaoPagamento(String solicitacaoPagamentoId);

	public Optional<RegistroEstacionamentoDocument> findByIdAndPagamentoStatus(String id, String status);

	
	
}
