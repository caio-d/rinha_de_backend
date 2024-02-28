package com.rinha.rinha.domain.transacao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Table(name = "tb_transacoes")
@Entity(name = "transacao")
@Getter
@Setter
@NoArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long valor;
    private String tipo;
    private String descricao;
    private LocalDate realizada_em;

//    public Transacao(TransacaoResponse response) {
//        this.valor = response.valor();
//        this.tipo = response.tipo();
//        this.descricao = response.descricao();
//        this.realizada_em = response.realizada_em();
//    }

    public Transacao(TransacaoRequest request) {
        this.valor = request.valor();
        this.tipo = request.tipo();
        this.descricao = request.descricao();
        this.realizada_em = LocalDate.now();
    }


}
