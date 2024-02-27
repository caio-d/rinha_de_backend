package com.rinha.rinha.controllers;

import com.rinha.rinha.domain.cliente.Cliente;
import com.rinha.rinha.domain.cliente.ClienteResponse;
import com.rinha.rinha.domain.transacao.Transacao;
import com.rinha.rinha.domain.transacao.TransacaoRequest;
import com.rinha.rinha.services.ClienteService;
import lombok.SneakyThrows;
import org.apache.coyote.Response;
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

    @SneakyThrows
    @PostMapping("/{clienteId}/transacoes")
    public ResponseEntity<ClienteResponse> insert(@PathVariable Long clienteId, @RequestBody TransacaoRequest transacaoRequest) {

        Optional<Cliente> clienteOptional = service.findById(clienteId);
        Cliente cliente = clienteOptional.orElseThrow();

        Transacao transacao = new Transacao(transacaoRequest);

        if (this.transacaoInvalida(transacao)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(new ClienteResponse(cliente));
    }

    public Boolean transacaoInvalida(Transacao transacao) {
        return transacao.getValor() <= 0 ||
                (!transacao.getTipo().equalsIgnoreCase("c") && !transacao.getTipo().equalsIgnoreCase("d")) ||
                transacao.getDescricao().length() > 10;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

}
