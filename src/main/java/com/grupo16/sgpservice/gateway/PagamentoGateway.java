package com.grupo16.sgpservice.gateway;

import com.grupo16.sgpservice.domain.Pagamento;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;

public interface PagamentoGateway {

	String solicitar(RegistroEstacionamentoBase registroEstacionamento);

	Pagamento findById(String solicitacaoPagamentoId);
	
}
