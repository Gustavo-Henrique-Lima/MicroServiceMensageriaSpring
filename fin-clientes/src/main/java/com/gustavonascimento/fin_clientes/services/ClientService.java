package com.gustavonascimento.fin_clientes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.fin_clientes.entities.Client;
import com.gustavonascimento.fin_clientes.entities.dto.ClientDTO;
import com.gustavonascimento.fin_clientes.repositories.ClientRepository;

import jakarta.transaction.Transactional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional
	public ClientDTO insertClient(ClientDTO entity) {
		Client client = new Client();
		copyDtoToEntity(client, entity);
		repository.save(client);
		return new ClientDTO(client);
	}

	@Transactional
	public Optional<Client> findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	private void copyDtoToEntity(Client user, ClientDTO dto) {
		user.setCpf(dto.getCpf());
		user.setNome(dto.getNome());
		user.setIdade(dto.getIdade());
		user.setScore(dto.getScore());
	}
}