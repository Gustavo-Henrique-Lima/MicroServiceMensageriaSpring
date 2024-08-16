package com.gustavonascimento.fin_avaliador.entities;

import java.io.Serializable;

public class ProtocoloSolicitacaoCartao implements Serializable {

	private static final long serialVersionUID = 1L;

	private String protocolo;

	public ProtocoloSolicitacaoCartao(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getProtocolo() {
		return protocolo;
	}

}