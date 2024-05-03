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
public class EmentaDTO {

    private long id;
    private LocalDate data;
    private String nomeSopa;
    private double quantidade;

    public EmentaDTO (LocalDate data, String nomeSopa, double quantidade) {
        this.data = data;
        this.nomeSopa = nomeSopa;
        this.quantidade = quantidade;
    }
}
