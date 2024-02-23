package com.rinha.rinha.domain.cliente;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_clientes")
@Entity(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long saldo;
    private Long limite;

    public Cliente(ClienteResponse clienteResponse) {
        this.saldo = clienteResponse.saldo();
        this.limite = clienteResponse.limite();
    }

}
