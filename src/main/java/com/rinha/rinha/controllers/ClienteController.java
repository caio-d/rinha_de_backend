package com.rinha.rinha.controllers;

import com.rinha.rinha.domain.cliente.Cliente;
import com.rinha.rinha.domain.cliente.ClienteResponse;
import com.rinha.rinha.domain.transacao.Transacao;
import com.rinha.rinha.domain.transacao.TransacaoRequest;
import com.rinha.rinha.services.ClienteService;
import com.rinha.rinha.services.TransacaoService;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final TransacaoService transacaoService;

    public ClienteController(ClienteService clienteService, TransacaoService transacaoService) {
        this.clienteService = clienteService;
        this.transacaoService = transacaoService;
    }

    @SneakyThrows
    @PostMapping("/{clienteId}/transacoes")
    public ResponseEntity<ClienteResponse> transacaoCliente(@PathVariable Long clienteId, @RequestBody TransacaoRequest transacaoRequest) {

        Transacao transacao = new Transacao(transacaoRequest);
        Cliente cliente = clienteService.findById(clienteId);
        boolean tipoTransacaoDebito = transacao.getTipo().equals("d");

        if (requestInvalido(transacao)) {
            return ResponseEntity.badRequest().build();
        } else if (transacaoInvalida(cliente, transacao)) {
            return ResponseEntity.status(422).body(new ClienteResponse(cliente));
        }

        if (tipoTransacaoDebito) {
            cliente.setSaldo(cliente.getSaldo() - transacao.getValor());
        } else {
            cliente.setLimite(cliente.getLimite() - transacao.getValor());

        }

        clienteService.save(cliente);
        transacaoService.save(transacao);

        return ResponseEntity.ok().body(new ClienteResponse(cliente));
    }

    public Boolean requestInvalido(Transacao transacao) {
        return transacao.getValor() <= 0 ||
                (!transacao.getTipo().equalsIgnoreCase("c") && !transacao.getTipo().equalsIgnoreCase("d")) ||
                transacao.getDescricao().length() > 10;
    }

    public boolean transacaoInvalida(Cliente cliente, Transacao transacao) {

        boolean tipoTransacaoDebito = transacao.getTipo().equals("d");
        long valorTransacao = transacao.getValor();
        long saldo = cliente.getSaldo();
        long limite = cliente.getLimite();
        long limiteRestante;

        if (tipoTransacaoDebito) {

            if (valorTransacao < 0) {
                limiteRestante = limite - saldo;
            } else {
                limiteRestante = limite + saldo;
            }

            if (limiteRestante > valorTransacao) return false;

            if (valorTransacao > saldo) return false;

            if (valorTransacao > (saldo + limite)) return false;

        } else {
            if (valorTransacao > limite) return false;
        }

        return false;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok().body(clienteService.getAll());
    }

}
