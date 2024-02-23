package com.rinha.rinha.domain.conta;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_conta")
@Entity(name = "conta")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long saldo;
    private Long limite;

    public Conta(ContaResponse contaResponse) {
        this.saldo = contaResponse.saldo();
        this.limite = contaResponse.limite();
    }

}
