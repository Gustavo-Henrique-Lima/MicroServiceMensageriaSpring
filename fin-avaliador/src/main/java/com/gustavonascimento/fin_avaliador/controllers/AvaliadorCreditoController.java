package com.gustavonascimento.fin_avaliador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.fin_avaliador.controllers.exception.ErroSolicitacaoException;
import com.gustavonascimento.fin_avaliador.controllers.exception.MicroServiceComunicattionException;
import com.gustavonascimento.fin_avaliador.controllers.exception.ResourceNotFoundException;
import com.gustavonascimento.fin_avaliador.entities.AvaliacaoCliente;
import com.gustavonascimento.fin_avaliador.entities.DadosAvaliacao;
import com.gustavonascimento.fin_avaliador.entities.DadosSolicitacao;
import com.gustavonascimento.fin_avaliador.entities.ProtocoloSolicitacaoCartao;
import com.gustavonascimento.fin_avaliador.entities.SituacaoCliente;
import com.gustavonascimento.fin_avaliador.service.AvaliadorService;

@RestController
@RequestMapping(value = "/avaliacoes-credito")
public class AvaliadorCreditoController {

	@Autowired
	private AvaliadorService service;

	@GetMapping
	public String status() {
		return "Avaliador de crédito Ok!";
	}

	@GetMapping(value = "/situacao-cliente", params = "cpf")
	public ResponseEntity<SituacaoCliente> consultaSituacaoCliente(@RequestParam String cpf) {
		try {
			SituacaoCliente situacaoCliente = service.obterSituacaoCliente(cpf);
			return ResponseEntity.ok(situacaoCliente);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (MicroServiceComunicattionException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping
	public ResponseEntity<AvaliacaoCliente> realizarAvaliacao(@RequestBody DadosAvaliacao dados) {
		try {
			AvaliacaoCliente avaliacaoCliente = service.realizarAvaliacao(dados.getCpf(), dados.getRenda());
			return ResponseEntity.ok(avaliacaoCliente);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (MicroServiceComunicattionException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping(value = "/solicitar-cartao")
	public ResponseEntity<ProtocoloSolicitacaoCartao> solicitarCartao(@RequestBody DadosSolicitacao dados) {
		try {
			ProtocoloSolicitacaoCartao protocolo = service.solicitarEmissaoCartao(dados);
			return ResponseEntity.ok(protocolo);
		} catch (ErroSolicitacaoException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}
}