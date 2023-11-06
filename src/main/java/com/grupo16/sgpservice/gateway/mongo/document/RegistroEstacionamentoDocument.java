package com.grupo16.sgpservice.gateway.mongo.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.domain.Pagamento;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoPeriodoFixo;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoPeriodoVariavel;
import com.grupo16.sgpservice.domain.TipoEstacionamento;
import com.grupo16.sgpservice.domain.Veiculo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class RegistroEstacionamentoDocument {
	
	@Id
	private String id;
	
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraTermino;
	private LocalDateTime dataHoraUltimaNotificacao;
	private LocalDateTime dataHoraPrevisaoNotificacao;
	private Long quantidadeHoras;
	protected PagamentoEntity pagamento;
	
	private Boolean deveNotificar;
	
	@DBRef
	private VeiculoDocument veiculo;
	private TipoEstacionamento tipo;
	
	public RegistroEstacionamentoDocument(RegistroEstacionamentoBase domain) {
		id = domain.getId();
		dataHoraInicio = domain.getDataHoraInicio().minusHours(3);//reduzindo 3 horas para se adequar ao fuso horario Brasil
		dataHoraTermino = domain.getDataHoraTermino() == null ? null : domain.getDataHoraTermino().minusHours(3);//reduzindo 3 horas para se adequar ao fuso horario Brasil
		quantidadeHoras = domain instanceof RegistroEstacionamentoPeriodoFixo ? ((RegistroEstacionamentoPeriodoFixo) domain).getQuantidadeHoras() : null;
		veiculo = VeiculoDocument.builder().id(domain.getVeiculo().getId()).build();
		tipo = domain instanceof RegistroEstacionamentoPeriodoFixo ? TipoEstacionamento.TEMPO_FIXO : TipoEstacionamento.TEMPO_VARIAVEL;
		dataHoraUltimaNotificacao = domain.getDataHoraUltimaNotificacao() == null ? null : domain.getDataHoraUltimaNotificacao().minusHours(3);
		dataHoraPrevisaoNotificacao = domain.getDataHoraPrevisaoNotificacao().minusHours(3);
		pagamento = domain.getPagamento() == null ? null : new PagamentoEntity(domain.getPagamento());
		deveNotificar = domain.getDeveNotificar();
	}
	
	public RegistroEstacionamentoBase parseRegistroDomain() {
		
		Condutor condutor = Condutor.builder()
				.id(veiculo.getCondutor().getId())
				.nome(veiculo.getCondutor().getNome()) 
				.cpf(veiculo.getCondutor().getCpf())
				.email(veiculo.getCondutor().getEmail()) 
				.telefone(veiculo.getCondutor().getTelefone())
				.build();
		
		Veiculo veiculoDomain = Veiculo.builder()
				.id(veiculo.getId())
				.marca(veiculo.getMarca())
				.modelo(veiculo.getModelo())
				.placa(veiculo.getPlaca())
				.condutor(condutor)
				.build();
		
		if(tipo.equals(TipoEstacionamento.TEMPO_FIXO)) {
			return RegistroEstacionamentoPeriodoFixo.builder()
					.id(id)
					.dataHoraInicio(dataHoraInicio.plusHours(3))
					.dataHoraTermino(dataHoraTermino.plusHours(3))
					.quantidadeHoras(quantidadeHoras)
					.dataHoraPrevisaoNotificacao(dataHoraPrevisaoNotificacao == null ? null : dataHoraPrevisaoNotificacao.plusHours(3))
					.veiculo(veiculoDomain)
					.pagamento(pagamento == null ? null : Pagamento.builder()
							.idSolicitacaoPagamento(this.pagamento.getIdSolicitacaoPagamento())
							.status(this.pagamento.getStatus())
							.valorPago(this.pagamento.getValorPago() == null ? null : this.pagamento.getValorPago())
							.build())
					.deveNotificar(deveNotificar)
					.build();
		} else {
			
			return RegistroEstacionamentoPeriodoVariavel.builder()
					.id(id)
					.dataHoraInicio(dataHoraInicio.plusHours(3))
					.dataHoraTermino(dataHoraTermino == null ? null : dataHoraTermino.plusHours(3))
					.dataHoraPrevisaoNotificacao(dataHoraPrevisaoNotificacao == null ? null : dataHoraPrevisaoNotificacao.plusHours(3))
					.veiculo(veiculoDomain)
					.pagamento(pagamento == null ? null : Pagamento.builder()
							.idSolicitacaoPagamento(this.pagamento.getIdSolicitacaoPagamento())
							.status(this.pagamento.getStatus())
							.valorPago(this.pagamento.getValorPago() == null ? null : this.pagamento.getValorPago())
							.build())
					.deveNotificar(deveNotificar)
					.build();
		}
	}
}
