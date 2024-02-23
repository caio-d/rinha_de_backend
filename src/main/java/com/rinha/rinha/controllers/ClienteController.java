package com.rinha.rinha.controllers;

import com.rinha.rinha.domain.cliente.Cliente;
import com.rinha.rinha.domain.transacao.Transacao;
import com.rinha.rinha.domain.transacao.TransacaoRequest;
import com.rinha.rinha.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService clienteService) {
        this.service = clienteService;
    }

    @PostMapping("/{clienteId}/transacoes")
    public ResponseEntity<Cliente> insert(@PathVariable Long clienteId, @RequestBody TransacaoRequest transacaoRequest) {

        Optional<Cliente> clienteOptional = service.findById(clienteId);
        Cliente cliente = clienteOptional.orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + clienteId));

        Transacao transacao = new Transacao(transacaoRequest);

        if (transacao.getValor() <= 0 || !transacao.getTipo().equals("c") || !transacao.getTipo().equals("d")) {
            return ResponseEntity.badRequest().build();
        }

        return null;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

}
