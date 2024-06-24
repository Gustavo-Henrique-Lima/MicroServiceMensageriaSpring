package com.gustavonascimento.fin_cartoes.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.fin_cartoes.entities.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, UUID>{

	@Query(value = "SELECT * FROM tb_cartao WHERE renda_minima <= :renda", nativeQuery = true)
	List<Cartao> findByRendaLessThanEquals(BigDecimal renda);
}