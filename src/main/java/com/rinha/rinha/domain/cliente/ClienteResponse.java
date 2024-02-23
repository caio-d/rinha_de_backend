package com.rinha.rinha.domain.cliente;

import lombok.NonNull;

public record ClienteResponse(Long saldo, Long limite) {

    public ClienteResponse(@NonNull Cliente cliente) {
        this(cliente.getSaldo(), cliente.getLimite());
    }

}
