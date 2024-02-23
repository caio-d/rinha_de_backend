package com.rinha.rinha.domain.extrato;

import lombok.NonNull;

import java.time.LocalDate;

public record ExtratoResponse(Long saldo_total, Long limite_tota, LocalDate data_extrato) {

    public ExtratoResponse(@NonNull Extrato extrato) {
        this(extrato.getSaldo_total(), extrato.getLimite_total(), extrato.getData_extrato());
    }

}
