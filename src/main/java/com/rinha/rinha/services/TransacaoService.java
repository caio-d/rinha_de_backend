package com.rinha.rinha.services;

import com.rinha.rinha.domain.conta.Conta;
import com.rinha.rinha.domain.transacao.Transacao;
import com.rinha.rinha.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.repository = transacaoRepository;
    }

    public void save(Transacao transacao) {
        this.repository.save(transacao);
    }

    public List<Transacao> getAll() {
        return this.repository.findAll();
    }

}
