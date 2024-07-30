package com.gustavonascimento.fin_avaliador.controllers.exception;

public class MicroServiceComunicattionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MicroServiceComunicattionException(String msg) {
		super(msg);
	}
}