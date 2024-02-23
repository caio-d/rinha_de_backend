package com.rinha.rinha.domain.conta;

import lombok.NonNull;

public record ContaResponse(Long saldo, Long limite) {

    public ContaResponse(@NonNull Conta conta) {
        this(conta.getSaldo(), conta.getLimite());
    }

}
