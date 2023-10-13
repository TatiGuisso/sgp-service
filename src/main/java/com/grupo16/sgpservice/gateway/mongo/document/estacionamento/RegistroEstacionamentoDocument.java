package com.grupo16.sgpservice.gateway.mongo.document.estacionamento;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.grupo16.sgpservice.domain.RegistroEstacionamentoBase;
import com.grupo16.sgpservice.domain.RegistroEstacionamentoPeriodoFixo;
import com.grupo16.sgpservice.domain.TipoEstacionamento;

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
public class RegistroEstacionamentoDocument {
	
	@Id
	private String id;
	
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraTermino;
	private VeiculoJson veiculo;//FIXME: anotar com @DbRef
	private TipoEstacionamento tipo;
	
	public RegistroEstacionamentoDocument(RegistroEstacionamentoBase domain) {
		id = domain.getId();
		dataHoraInicio = domain.getDataHoraInicio();
		dataHoraTermino = domain.getDataHoraTermino();
		veiculo = VeiculoJson.builder().id(domain.getId()).build();
		tipo = domain instanceof RegistroEstacionamentoPeriodoFixo ? TipoEstacionamento.TEMPO_FIXO : TipoEstacionamento.TEMPO_DINAMICO;
	}
	
}
