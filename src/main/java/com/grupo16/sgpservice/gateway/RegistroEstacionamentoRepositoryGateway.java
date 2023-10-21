package com.grupo16.sgpservice.gateway;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;

public interface RegistroEstacionamentoRepositoryGateway {
	
	String criar(RegistroEstacionamentoBase registroEstacionamentoBase);

	RegistroEstacionamentoBase getById(String id);
	
	List<RegistroEstacionamentoBase> getByDataHoraInicioBetweenDataHoraTermino(LocalDateTime dataHoraInicio, LocalDateTime dataHoraTermino);

}
