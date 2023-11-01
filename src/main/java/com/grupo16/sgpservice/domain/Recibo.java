package com.grupo16.sgpservice.domain;

import lombok.ToString;

@ToString
public class Recibo {
	
	private String registroEstacionamentoId;
	private Pagamento pagamento;
	private Veiculo veiculo;

}
