package com.rinha.rinha.services;

import com.rinha.rinha.domain.conta.Conta;
import com.rinha.rinha.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private final ContaRepository repository;

    @Autowired
    public ContaService(ContaRepository contaRepository) {
        this.repository = contaRepository;
    }

    public void save(Conta conta) {
        this.repository.save(conta);
    }

}
