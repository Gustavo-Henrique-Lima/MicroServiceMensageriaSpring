package com.gustavonascimento.fin_cartoes.entities.enums;

public enum BandeiraCartao {

	MASTERCARD(0), VISA(1);

	private int code;

	private BandeiraCartao(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static BandeiraCartao getValueTurnStatus(int code) {
		for (BandeiraCartao value : BandeiraCartao.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de status inválido");
	}
}