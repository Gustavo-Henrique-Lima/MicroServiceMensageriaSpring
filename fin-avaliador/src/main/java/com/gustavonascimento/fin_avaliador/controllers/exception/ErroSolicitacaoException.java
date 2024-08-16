package com.gustavonascimento.fin_avaliador.controllers.exception;

public class ErroSolicitacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErroSolicitacaoException(String msg) {
		super(msg);
	}

}