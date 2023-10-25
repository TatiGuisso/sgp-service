package com.grupo16.sgpservice.gateway;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;

public interface RegistroEstacionamentoRepositoryGateway {
	
	String salvar(RegistroEstacionamentoBase registroEstacionamento);
	
	void salvar(List<RegistroEstacionamentoBase> registrosEstacionamento);

	RegistroEstacionamentoBase getById(String id);
	
	List<RegistroEstacionamentoBase> getByDataHoraPrevisaoNotificacaoBetween(LocalDateTime dataHoraInicio, LocalDateTime dataHoraTermino);

	Optional<RegistroEstacionamentoBase> getBySolicitacaoPagamento(String solicitacaoPagamentoId);

}
