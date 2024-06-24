package com.gustavonascimento.fin_avaliador.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_situacao_cliente")
public class SituacaoCliente {

	private DadosCliente cliente;
	private List<CartaoCliente> cartoes;

	public SituacaoCliente() {
	}

	public SituacaoCliente(DadosCliente cliente, List<CartaoCliente> cartoes) {
		this.cliente = cliente;
		this.cartoes = cartoes;
	}

	public DadosCliente getCliente() {
		return cliente;
	}

	public void setCliente(DadosCliente cliente) {
		this.cliente = cliente;
	}

	public List<CartaoCliente> getCartoes() {
		return cartoes;
	}

	public void addCartao(CartaoCliente cartao) {
		this.cartoes.add(cartao);
	}
	
	
	
}