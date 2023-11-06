package com.grupo16.sgpservice.gateway;

import com.grupo16.sgpservice.domain.Pagamento;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.dto.SolicitarPagamentoReturnDto;

public interface PagamentoGateway {

	SolicitarPagamentoReturnDto solicitar(RegistroEstacionamentoBase registroEstacionamento);

	Pagamento findById(String solicitacaoPagamentoId);
	
}
