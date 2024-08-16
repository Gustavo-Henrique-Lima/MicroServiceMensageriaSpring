package com.gustavonascimento.fin_avaliador.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class DadosSolicitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID idCartao;
	private String cpf;
	private String endereco;
	private BigDecimal limiteLiberado;
	private String tipo;
	private LocalDate vencimento;

	public DadosSolicitacao() {
	}

	public DadosSolicitacao(UUID idCartao, String cpf, String endereco, BigDecimal limiteLiberado, String tipo,
			LocalDate vencimento) {
		this.idCartao = idCartao;
		this.cpf = cpf;
		this.endereco = endereco;
		this.limiteLiberado = limiteLiberado;
		this.tipo = tipo;
		this.vencimento = vencimento;
	}

	public UUID getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(UUID idCartao) {
		this.idCartao = idCartao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getLimiteLiberado() {
		return limiteLiberado;
	}

	public void setLimiteLiberado(BigDecimal limiteLiberado) {
		this.limiteLiberado = limiteLiberado;
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