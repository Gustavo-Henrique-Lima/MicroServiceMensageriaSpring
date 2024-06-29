package com.gustavonascimento.fin_avaliador.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class CartaoCliente {

	private String nome;
	private String bandeiraCartao;
	private BigDecimal limiteBasico;

	public CartaoCliente() {
	}

	public CartaoCliente(String nome, String bandeiraCartao, BigDecimal limiteBasico) {
		this.nome = nome;
		this.bandeiraCartao = bandeiraCartao;
		this.limiteBasico = limiteBasico;
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

	public BigDecimal getLimiteBasico() {
		return limiteBasico;
	}

	public void setLimiteBasico(BigDecimal limiteBasico) {
		this.limiteBasico = limiteBasico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bandeiraCartao, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaoCliente other = (CartaoCliente) obj;
		return Objects.equals(bandeiraCartao, other.bandeiraCartao) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "CartaoCliente [nome=" + nome + ", bandeiraCartao=" + bandeiraCartao + ", limiteBasico=" + limiteBasico
				+ "]";
	}
}