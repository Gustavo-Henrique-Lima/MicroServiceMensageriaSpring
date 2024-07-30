package com.gustavonascimento.fin_cartoes.entities.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.gustavonascimento.fin_cartoes.entities.CartaoCliente;
import com.gustavonascimento.fin_cartoes.entities.enums.BandeiraCartao;

public class CartaoClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	private String nome;
	private BandeiraCartao bandeiraCartao;
	private BigDecimal limiteBasico;
	private String tipo;
	private LocalDate vencimento;

	public CartaoClienteDTO() {
	}

	public CartaoClienteDTO(UUID id, String nome, BandeiraCartao bandeiraCartao, BigDecimal limiteBasico, String tipo,
			LocalDate vencimento) {
		this.id = id;
		this.nome = nome;
		this.bandeiraCartao = bandeiraCartao;
		this.limiteBasico = limiteBasico;
		this.tipo = tipo;
		this.vencimento = vencimento;
	}

	public CartaoClienteDTO(CartaoCliente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.bandeiraCartao = entity.getBandeiraCartao();
		this.limiteBasico = entity.getLimiteBasico();
		this.tipo = entity.getTipo();
		this.vencimento = entity.getVencimento();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BandeiraCartao getBandeiraCartao() {
		return bandeiraCartao;
	}

	public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	public BigDecimal getLimiteBasico() {
		return limiteBasico;
	}

	public void setLimiteBasico(BigDecimal limiteBasico) {
		this.limiteBasico = limiteBasico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

}
