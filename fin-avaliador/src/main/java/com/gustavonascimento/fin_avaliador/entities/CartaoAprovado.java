package com.gustavonascimento.fin_avaliador.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CartaoAprovado {

	private String nome;
	private String bandeiraCartao;
	private BigDecimal limiteAprovado;
	private LocalDate vencimento;
	private String tipo;

	public CartaoAprovado() {
	}

	public CartaoAprovado(String nome, String bandeiraCartao, BigDecimal limiteAprovado, LocalDate vencimento, String tipo) {
		this.nome = nome;
		this.bandeiraCartao = bandeiraCartao;
		this.limiteAprovado = limiteAprovado;
		this.vencimento = vencimento;
		this.tipo = tipo;
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