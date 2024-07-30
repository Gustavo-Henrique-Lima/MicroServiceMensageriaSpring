package com.gustavonascimento.fin_cartoes.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavonascimento.fin_cartoes.entities.Cartao;
import com.gustavonascimento.fin_cartoes.entities.CartaoCliente;
import com.gustavonascimento.fin_cartoes.entities.ClienteCartao;
import com.gustavonascimento.fin_cartoes.entities.DadosSolicitacao;
import com.gustavonascimento.fin_cartoes.repository.CartaoClienteRepository;
import com.gustavonascimento.fin_cartoes.repository.CartaoRepository;
import com.gustavonascimento.fin_cartoes.repository.ClienteCartaoRepository;

import jakarta.transaction.Transactional;

@Component
public class Subscriber {

	@Autowired
	private CartaoRepository repository;

	@Autowired
	private ClienteCartaoRepository clienteRepository;

	@Autowired
	private CartaoClienteRepository cartaoRepository;

	@RabbitListener(queues = "${mq.queues.emissao-cartoes}")
	@Transactional
	public void receberSolicitacaoEmissao(@Payload String payload) {
		var mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		try {
			DadosSolicitacao dados = mapper.readValue(payload, DadosSolicitacao.class);
			Cartao obj = repository.findById(dados.getIdCartao())
					.orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
			CartaoCliente cartao = new CartaoCliente(obj, dados.getTipo(), dados.getVencimento());
			cartaoRepository.save(cartao);
			ClienteCartao cliente = new ClienteCartao();
			cliente.setCpf(dados.getCpf());
			cliente.setLimite(dados.getLimiteLiberado());
			cliente.setCartao(cartao);
			clienteRepository.save(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}