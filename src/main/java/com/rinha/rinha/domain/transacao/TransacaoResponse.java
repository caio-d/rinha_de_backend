package com.rinha.rinha.domain.transacao;

import jakarta.annotation.Nonnull;

import java.time.LocalDate;

public record TransacaoResponse(Long valor, String tipo, String descricao, LocalDate realizada_em) {

    public TransacaoResponse(@Nonnull Transacao transacao) {
        this(transacao.getValor(), transacao.getTipo(), transacao.getDescricao(), transacao.getRealizada_em());
    }

}
