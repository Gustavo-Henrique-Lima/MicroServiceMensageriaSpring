package com.gustavonascimento.fin_avaliador.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gustavonascimento.fin_avaliador.controllers.exception.ErroSolicitacaoException;
import com.gustavonascimento.fin_avaliador.controllers.exception.MicroServiceComunicattionException;
import com.gustavonascimento.fin_avaliador.controllers.exception.ResourceNotFoundException;
import com.gustavonascimento.fin_avaliador.entities.AvaliacaoCliente;
import com.gustavonascimento.fin_avaliador.entities.CartaoAprovado;
import com.gustavonascimento.fin_avaliador.entities.CartaoCliente;
import com.gustavonascimento.fin_avaliador.entities.DadosCliente;
import com.gustavonascimento.fin_avaliador.entities.DadosSolicitacao;
import com.gustavonascimento.fin_avaliador.entities.ProtocoloSolicitacaoCartao;
import com.gustavonascimento.fin_avaliador.entities.SituacaoCliente;
import com.gustavonascimento.fin_avaliador.infra.CartoesResourceClient;
import com.gustavonascimento.fin_avaliador.infra.ClientsResourceClient;
import com.gustavonascimento.fin_avaliador.infra.mqueue.Publisher;

@Service
public class AvaliadorService {

	@Autowired
	private ClientsResourceClient clientsClient;

	@Autowired
	private CartoesResourceClient cartoesClient;

	@Autowired
	private Publisher publisher;

	public SituacaoCliente obterSituacaoCliente(String cpf)
			throws ResourceNotFoundException, MicroServiceComunicattionException {
		try {
			ResponseEntity<DadosCliente> dadosClientes = clientsClient.findByCPF(cpf);
			System.out.println(cartoesClient.getCartoesByCliente(cpf).getBody());
			ResponseEntity<List<CartaoCliente>> cartoesCliente = cartoesClient.getCartoesByCliente(cpf);
			return new SituacaoCliente(dadosClientes.getBody(), cartoesCliente.getBody());
		} catch (feign.FeignException.FeignClientException e) {
			int status = e.status();
			if (HttpStatus.NOT_FOUND.value() == status) {
				throw new ResourceNotFoundException("Cliente não encontrado na nossa base de dados.");
			}
			throw new MicroServiceComunicattionException(e.getMessage());
		}

	}

	public AvaliacaoCliente realizarAvaliacao(String cpf, Long renda)
			throws ResourceNotFoundException, MicroServiceComunicattionException {
		try {
			ResponseEntity<DadosCliente> dadosClientes = clientsClient.findByCPF(cpf);
			ResponseEntity<List<CartaoCliente>> cartoesDisponiveis = cartoesClient.getCartaoByRenda(renda);
			List<CartaoCliente> cartoes = cartoesDisponiveis.getBody();

			var cartoesAprovados = cartoes.stream().map(cartao -> {
				DadosCliente cliente = dadosClientes.getBody();
				CartaoAprovado aprovado = fabricarCartao(cliente, cartao);
				return aprovado;
			}).collect(Collectors.toList());

			return new AvaliacaoCliente(cartoesAprovados);

		} catch (feign.FeignException.FeignClientException e) {
			int status = e.status();
			if (HttpStatus.NOT_FOUND.value() == status) {
				throw new ResourceNotFoundException("Cliente não encontrado na nossa base de dados.");
			}
			throw new MicroServiceComunicattionException(e.getMessage());
		}

	}

	private CartaoAprovado fabricarCartao(DadosCliente cliente, CartaoCliente cartao) {
		BigDecimal limiteBasico = cartao.getLimiteBasico();
		double rank = cliente.getIdade() * cliente.getScore() * 30;
		BigDecimal factor = BigDecimal.valueOf(rank);
		BigDecimal valorLiberado = (limiteBasico.divide(BigDecimal.valueOf(2.0d)).add(factor));
		LocalDate date = LocalDate.now();

		CartaoAprovado card = new CartaoAprovado();
		card.setId(cartao.getId());
		card.setNome(cartao.getNome());
		card.setBandeiraCartao(cartao.getBandeiraCartao());
		card.setLimiteAprovado(valorLiberado);
		card.setVencimento(date.plusYears(4));
		card.setTipo(tipoCartao(cliente.getScore()));
		return card;
	}

	private String tipoCartao(Integer score) {
		if (score >= 7) {
			return "Crédito";
		}
		return "Débito";
	}

	public ProtocoloSolicitacaoCartao solicitarEmissaoCartao(DadosSolicitacao dados) {
		try {
			publisher.solicitarCartao(dados);
			var protocolo = UUID.randomUUID().toString();
			return new ProtocoloSolicitacaoCartao(protocolo);
		} catch (Exception e) {
			throw new ErroSolicitacaoException(e.getMessage());
		}
	}
}