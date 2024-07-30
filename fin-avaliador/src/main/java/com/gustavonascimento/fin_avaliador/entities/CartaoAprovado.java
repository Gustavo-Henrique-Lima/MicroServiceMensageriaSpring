package com.gustavonascimento.fin_avaliador.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class CartaoAprovado {

	private UUID id;
	private String nome;
	private String bandeiraCartao;
	private BigDecimal limiteAprovado;
	private LocalDate vencimento;
	private String tipo;

	public CartaoAprovado() {
	}

	public CartaoAprovado(UUID id, String nome, String bandeiraCartao, BigDecimal limiteAprovado, LocalDate vencimento,
			String tipo) {
		this.id = id;
		this.nome = nome;
		this.bandeiraCartao = bandeiraCartao;
		this.limiteAprovado = limiteAprovado;
		this.vencimento = vencimento;
		this.tipo = tipo;
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

	public String getBandeiraCartao() {
		return bandeiraCartao;
	}

	public void setBandeiraCartao(String bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	public BigDecimal getLimiteAprovado() {
		return limiteAprovado;
	}

	public void setLimiteAprovado(BigDecimal limiteAprovado) {
		this.limiteAprovado = limiteAprovado;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}