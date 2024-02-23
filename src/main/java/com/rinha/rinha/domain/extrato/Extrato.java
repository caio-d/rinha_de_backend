package com.rinha.rinha.domain.extrato;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "tb_extrato")
@Entity(name = "extrato")
@Getter
@Setter
@NoArgsConstructor
public class Extrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long saldo_total;
    private Long limite_total;
    private LocalDate data_extrato;


}
