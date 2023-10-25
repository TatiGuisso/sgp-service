package com.grupo16.sgpservice.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString
public abstract class RegistroEstacionamentoBase {
	private String id;
	protected LocalDateTime dataHoraInicio;
	protected LocalDateTime dataHoraTermino;
	
	@Setter
	protected Pagamento pagamento;
	
	@Setter
	protected LocalDateTime dataHoraPrevisaoNotificacao;
	
	@Setter
	protected LocalDateTime dataHoraUltimaNotificacao;
	
	protected Boolean deveNotificar;
	
	protected List<Notificacao> notificacoes;
	protected Veiculo veiculo;
	protected Recibo recibo;
	protected Tarifa tarifa;
	
	public void iniciar(Long minutosProximaNotificacao) {
		dataHoraInicio = LocalDateTime.now();
		dataHoraPrevisaoNotificacao = dataHoraInicio.plusMinutes(minutosProximaNotificacao); 
	}
	
	public abstract BigDecimal getValor();
	
	public void setStatusPagamento(StatusPagamento statusPagamento) {
		pagamento.setStatus(statusPagamento);
	}

	public void criarSolicitacaoPagamento(String idSolicitacaoPagamento) {
		pagamento = Pagamento.builder()
				.idSolicitacaoPagamento(idSolicitacaoPagamento)
				.status(StatusPagamento.AGUARDANDO_PAGAMENTO).build();
	}
}
