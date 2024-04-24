package com.ProjetoII.fronted.DataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RefeicaoDTO {

    private long id;
    private LocalDateTime dataEhora;
    //private long nRefeicoes; não é um parametro mas sim uma soma de todos os registos que haverá
    private double volumeSopaDesperdicado;

    public RefeicaoDTO(LocalDateTime dataEhora, double volumeSopaDesperdicado) {
        this.dataEhora = dataEhora;
        this.volumeSopaDesperdicado = volumeSopaDesperdicado;
    }
}

