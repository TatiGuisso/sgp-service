package com.grupo16.sgpservice.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.sgpservice.domain.Condutor;
import com.grupo16.sgpservice.domain.Veiculo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class VeiculoJson {

	private String id;
	private String marca;
	private String modelo;
	
	@NotBlank
	private String placa;
	private CondutorJson condutor;

	public Veiculo parseVeiculoDomain(String idVeiculo) {

		return  Veiculo.builder()
				.id(idVeiculo == null ? this.id : idVeiculo)
				.marca(marca)
				.modelo(modelo)
				.placa(placa)
				.condutor(condutor == null ? null : Condutor.builder().id(condutor.getId()).build())
				.build();
	}

	public VeiculoJson(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.placa = veiculo.getPlaca();
		this.condutor = veiculo.getCondutor() == null ? null : new CondutorJson(veiculo.getCondutor());
	}

}
