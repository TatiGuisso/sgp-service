package com.grupo16.sgpservice.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.Notificacao;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoPeriodoVariavel;
import com.grupo16.sgpservice.gateway.NotificacaoRepositoryGateway;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificacaoUseCase {

	@Value("${minutosProximaNotificacao}")
	private Long minutosProximaNotificacao;
	
	@Autowired
	private RegistroEstacionamentoRepositoryGateway estacionamentoRepositoryGateway;

	@Autowired
	private NotificacaoRepositoryGateway notificacaoRepositoryGateway;
	
	//Schedular no tempo do range de datas
	public void notificar() {
		final LocalDateTime now = LocalDateTime.now();
		final LocalDateTime dataHoraFiltroInicio = now.minusMinutes(10);
		final LocalDateTime dataHoraFiltroFim = now.plusMinutes(10);
		
		log.info("rangeInicio={}, rangeFim={}",dataHoraFiltroInicio,dataHoraFiltroFim);
		
		List<RegistroEstacionamentoBase> registrosEstacionamento =  estacionamentoRepositoryGateway.getByDataHoraPrevisaoNotificacaoBetween(dataHoraFiltroInicio, dataHoraFiltroFim);
		
		List<Notificacao> notificacoes = new ArrayList<>();
		
		for (RegistroEstacionamentoBase re : registrosEstacionamento) {
			re.setDataHoraUltimaNotificacao(now);
			
			if(re instanceof RegistroEstacionamentoPeriodoVariavel) {
				re.setDataHoraPrevisaoNotificacao(re.getDataHoraPrevisaoNotificacao().plusHours(1));
			} else {
				re.setDeveNotificar(false);
			}
			
			notificacoes.add(Notificacao.builder().registroEstacionamento(re).build());
		}
		
		if(!registrosEstacionamento.isEmpty()) {
			notificacaoRepositoryGateway.notificar(notificacoes);//Não implementado. Deve chamar um serviço que irá notificar.
			estacionamentoRepositoryGateway.salvar(registrosEstacionamento);
		}
	}
}
