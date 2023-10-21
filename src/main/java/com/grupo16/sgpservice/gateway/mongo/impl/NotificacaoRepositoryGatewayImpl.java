package com.grupo16.sgpservice.gateway.mongo.impl;

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
		try {
			//
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
