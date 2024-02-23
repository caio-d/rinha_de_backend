package com.rinha.rinha.services;

import com.rinha.rinha.domain.cliente.Cliente;
import com.rinha.rinha.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }

    public Optional<Cliente> findById(Long id) {
        return this.repository.findById(id).map(Optional::of).orElseThrow();
    }

    public List<Cliente> getAll() {
        return this.repository.findAll();
    }

}
