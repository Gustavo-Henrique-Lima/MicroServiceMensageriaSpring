package com.gustavonascimento.fin_avaliador.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CartaoAprovado> cartoes = new ArrayList<>();

	public AvaliacaoCliente(List<CartaoAprovado> cartoes) {
		this.cartoes = cartoes;
	}

	public List<CartaoAprovado> getCartoes() {
		return cartoes;
	}

}