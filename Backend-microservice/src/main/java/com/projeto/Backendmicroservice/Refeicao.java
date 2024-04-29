package com.projeto.Backendmicroservice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate data;
   //private long nRefeicoes; não é um parametro mas sim uma soma de todos os registos que haverá
    private double volumeSopaDesperdicado;
    private boolean tigela;

    public Refeicao(LocalDate data, double volumeSopaDesperdicado, boolean tigela) {
        this.data = data;
        this.volumeSopaDesperdicado = volumeSopaDesperdicado;
        this.tigela = tigela;
    }
}
