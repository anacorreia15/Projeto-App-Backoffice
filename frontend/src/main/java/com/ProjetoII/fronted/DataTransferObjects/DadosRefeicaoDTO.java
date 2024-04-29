package com.ProjetoII.fronted.DataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DadosRefeicaoDTO {
    private LocalDate data;
    private double volumeSopaDesperdicado;
}
