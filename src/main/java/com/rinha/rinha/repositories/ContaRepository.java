package com.rinha.rinha.repositories;

import com.rinha.rinha.domain.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}

