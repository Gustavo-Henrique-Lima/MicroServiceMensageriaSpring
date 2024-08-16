package com.gustavonascimento.fin_cartoes.entities.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import com.gustavonascimento.fin_cartoes.entities.ClienteCartao;

public class ClienteCartaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	private String cpf;
	private CartaoClienteDTO cartao;
	private BigDecimal limite;

	public ClienteCartaoDTO() {
	}

	public ClienteCartaoDTO(UUID id, String cpf, CartaoClienteDTO cartao, BigDecimal limite) {
		this.id = id;
		this.cpf = cpf;
		this.cartao = cartao;
		this.limite = limite;
	}

	public ClienteCartaoDTO(ClienteCartao entity) {
		this.id = entity.getId();
		this.cpf = entity.getCpf();
		this.cartao = new CartaoClienteDTO(entity.getCartao());
		this.limite = entity.getLimite();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public CartaoClienteDTO getCartao() {
		return cartao;
	}

	public void setCartao(CartaoClienteDTO cartao) {
		this.cartao = cartao;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

}