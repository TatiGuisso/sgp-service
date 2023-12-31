package com.grupo16.sgpservice.controller.json;

import java.time.LocalDateTime;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoPeriodoFixo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RegistroEstacionamentoJson {
	private String id;
	private String tipo;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraTermino;
	private Double valor;
	private PagamentoJson pagamento;
	private VeiculoJson veiculo;
	
	public RegistroEstacionamentoJson(RegistroEstacionamentoBase registroEstacionamento) {
		id = registroEstacionamento.getId();
		tipo = registroEstacionamento instanceof RegistroEstacionamentoPeriodoFixo ? "FIXO" : "VARIAVEL";
		dataHoraInicio = registroEstacionamento.getDataHoraInicio();
		dataHoraTermino = registroEstacionamento.getDataHoraTermino();
		valor = registroEstacionamento.getValor().doubleValue();
		pagamento =  registroEstacionamento.getPagamento() == null ? null : new PagamentoJson(registroEstacionamento.getPagamento());
		veiculo = new VeiculoJson(registroEstacionamento.getVeiculo());
	}

}
