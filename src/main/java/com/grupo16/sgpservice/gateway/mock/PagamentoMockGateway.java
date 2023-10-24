package com.grupo16.sgpservice.gateway.mock;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.gateway.PagamentoGateway;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PagamentoMockGateway implements PagamentoGateway {

	@Override
	public String solicitar(RegistroEstacionamentoBase registroEstacionamento) {
		
		/*
		 * Esta classe (adapter) representa um mock de pagamento (fins didáticos). 
		 * Na pratica implementar uma classe (adpter) qual chama um mercado pago por exemplo
		 * 
		 */
		
		log.warn("### MOCK DE PAGAMENTO ###");
		
		return UUID.randomUUID().toString();
	}

}
