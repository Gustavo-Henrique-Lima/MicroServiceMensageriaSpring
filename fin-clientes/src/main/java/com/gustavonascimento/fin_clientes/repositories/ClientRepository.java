package com.gustavonascimento.fin_clientes.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.fin_clientes.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID>{

	Optional<Client> findByCpf(String cpf);
}