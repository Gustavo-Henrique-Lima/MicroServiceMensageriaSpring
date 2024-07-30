package com.gustavonascimento.fin_cartoes.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.gustavonascimento.fin_cartoes.entities.enums.BandeiraCartao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cartao_cliente")
public class CartaoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	private UUID id;
	private String nome;
	private BandeiraCartao bandeiraCartao;
	private BigDecimal limiteBasico;
	private String tipo;
	private LocalDate vencimento;

	public CartaoCliente() {
	}

	public CartaoCliente(UUID id, String nome, BandeiraCartao bandeiraCartao, BigDecimal limiteBasico, String tipo,
			LocalDate vencimento) {
		this.id = id;
		this.nome = nome;
		this.bandeiraCartao = bandeiraCartao;
		this.limiteBasico = limiteBasico;
		this.tipo = tipo;
		this.vencimento = vencimento;
	}

	public CartaoCliente(Cartao cartao, String tipo, LocalDate vencimento) {
		this.nome = cartao.getNome();
		this.bandeiraCartao = cartao.getBandeiraCartao();
		this.limiteBasico = cartao.getLimiteBasico();
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

}