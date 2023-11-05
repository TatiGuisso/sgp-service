package com.grupo16.sgpservice.gateway.mongo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.grupo16.sgpservice.domain.Notificacao;
import com.grupo16.sgpservice.gateway.NotificacaoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificacaoRepositoryGatewayImpl implements NotificacaoRepositoryGateway{
	
	@Override
	public void notificar(List<Notificacao> notificacoes) {
		List<String> estacionamentosId = new ArrayList<>();
		
		notificacoes.forEach(n -> {
			String id = n.getRegistroEstacionamento().getId();
			estacionamentosId.add(id);
		});
		
		log.info("Notificados: {}", estacionamentosId);		
		log.warn("### NÃO HA NOTIFICAÇÃO IMPLEMENTADA NESTA VERSÃO: MAS DEVE CHAMAR UM SERVIÇO ESPECIFICO ###");
	}

}
