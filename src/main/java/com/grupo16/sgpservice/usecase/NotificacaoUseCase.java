package com.grupo16.sgpservice.usecase;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Notificacao;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.gateway.NotificacaoRepositoryGateway;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;

@Service
public class NotificacaoUseCase {
	
	@Autowired
	private RegistroEstacionamentoRepositoryGateway estacionamentoRepositoryGateway;

	@Autowired
	private NotificacaoRepositoryGateway notificacaoRepositoryGateway;
	
	public void notificar(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
		
		//FIXME remover parametros, descomentar as datas abaixo:
		
//		LocalDateTime dataHoraInicio = LocalDateTime.now();
//		LocalDateTime dataHoraFim = LocalDateTime.now().plusMinutes(20);
		
		List<RegistroEstacionamentoBase> registrosEstacionamento = 
				estacionamentoRepositoryGateway.getByDataHoraInicioBetweenDataHoraTermino(dataHoraInicio, dataHoraFim);
		
		List<Notificacao> notificacoes = new ArrayList<>();
		
		for (RegistroEstacionamentoBase re : registrosEstacionamento) {
			
			notificacoes.add(Notificacao.builder()
					.dataHoraInicio(dataHoraInicio)
					.dataHoraExpiracao(dataHoraFim)
					.registroEstacionamento(re)
					.build());
		}
		
		System.out.println("notificacoes: "+ notificacoes);
		notificacaoRepositoryGateway.notificar(notificacoes);//Ainda não existe. Deve chamar um serviço que irá notificar.
		
	}

}
