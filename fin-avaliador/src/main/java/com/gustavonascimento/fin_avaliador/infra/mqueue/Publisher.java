package com.gustavonascimento.fin_avaliador.infra.mqueue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gustavonascimento.fin_avaliador.entities.DadosSolicitacao;

@Component
public class Publisher {

	private final RabbitTemplate rabbitTemplate;
	private final Queue queue;

	public Publisher(RabbitTemplate rabbitTemplate, Queue queue) {
		this.rabbitTemplate = rabbitTemplate;
		this.queue = queue;
	}

	public void solicitarCartao(DadosSolicitacao dados) throws JsonProcessingException {
		var json = convertInJson(dados);
		rabbitTemplate.convertAndSend(queue.getName(), json);
	}

	private String convertInJson(DadosSolicitacao dados) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		var json = mapper.writeValueAsString(dados);
		return json;
	}

	public RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}

	public Queue getQueue() {
		return queue;
	}

}