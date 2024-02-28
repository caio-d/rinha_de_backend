package com.rinha.rinha.services;

import com.rinha.rinha.domain.cliente.Cliente;
import com.rinha.rinha.domain.transacao.Transacao;
import com.rinha.rinha.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }

    public Cliente findById(Long id) throws ChangeSetPersister.NotFoundException {
        return this.repository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void save(Cliente cliente) {
        this.repository.save(cliente);
    }

    public List<Cliente> getAll() {
        return this.repository.findAll();
    }

}
