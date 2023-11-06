package com.grupo16.sgpservice.gateway;

import java.util.List;

import com.grupo16.sgpservice.domain.Notificacao;

public interface NotificacaoRepositoryGateway {
	
	public void notificar(List<Notificacao> notificacoes);

}
