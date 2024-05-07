package com.projeto.Backendmicroservice.Refeicao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DadosRefeicao {
    private LocalDate data;
    private double volumeSopaDesperdicado;
}

