package com.rinha.rinha.controllers;
import com.rinha.rinha.domain.transacao.Transacao;
import com.rinha.rinha.services.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService transacaoService) {
        this.service = transacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}
