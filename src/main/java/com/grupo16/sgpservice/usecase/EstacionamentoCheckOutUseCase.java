package com.grupo16.sgpservice.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.dto.SolicitarPagamentoReturnDto;
import com.grupo16.sgpservice.gateway.PagamentoGateway;
import com.grupo16.sgpservice.gateway.RegistroEstacionamentoRepositoryGateway;

@Service
public class EstacionamentoCheckOutUseCase {

	@Autowired
	private GetEstacionamentoUseCase getEstacionamentoUseCase;
	
	@Autowired
	private RegistroEstacionamentoRepositoryGateway registroEstacionamentoRepositoryGateway;
	
	@Autowired
	private PagamentoGateway pagamentoGateway;
	
	public SolicitarPagamentoReturnDto checkOut(String idRegistroEstacionamento) {
		
		RegistroEstacionamentoBase rEstacionamento = getEstacionamentoUseCase.getById(idRegistroEstacionamento);
		rEstacionamento.encerrar();
		
		SolicitarPagamentoReturnDto solicitarPagamentoReturnDto = pagamentoGateway.solicitar(rEstacionamento);
		
		rEstacionamento.criarSolicitacaoPagamento(solicitarPagamentoReturnDto.getSolicitacaoPagamentoId());
		
		registroEstacionamentoRepositoryGateway.salvar(rEstacionamento);
		
		return solicitarPagamentoReturnDto;
	}
	
}
