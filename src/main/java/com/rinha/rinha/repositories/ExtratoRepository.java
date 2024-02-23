package com.rinha.rinha.repositories;

import com.rinha.rinha.domain.extrato.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtratoRepository extends JpaRepository<Extrato, Long> {
}
