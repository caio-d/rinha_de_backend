package com.rinha.rinha.controllers;

import com.rinha.rinha.domain.transacao.Transacao;
import com.rinha.rinha.domain.transacao.TransacaoRequest;
import com.rinha.rinha.domain.transacao.TransacaoResponse;
import com.rinha.rinha.services.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/clientes")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService transacaoService) {
        this.service = transacaoService;
    }

    @PostMapping("/{clienteId}/transacoes")
    public ResponseEntity<Transacao> insert(@PathVariable Long clienteId, @RequestBody TransacaoRequest transacaoRequest) {
        Transacao transacao = new Transacao(transacaoRequest);
        service.save(transacao);
        return ResponseEntity.ok().body(transacao);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }


}
