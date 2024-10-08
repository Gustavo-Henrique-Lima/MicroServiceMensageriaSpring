package com.gustavonascimento.fin_avaliador.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class CartaoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	private String nome;
	private String bandeiraCartao;
	private BigDecimal limiteBasico;
	private String tipo;
	private LocalDate vencimento;

	public CartaoCliente() {
	}

	public CartaoCliente(UUID id, String nome, String bandeiraCartao, BigDecimal limiteBasico, String tipo,
			LocalDate vencimento) {
		this.id = id;
		this.nome = nome;
		this.bandeiraCartao = bandeiraCartao;
		this.limiteBasico = limiteBasico;
		this.tipo = tipo;
		this.vencimento = vencimento;
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
}