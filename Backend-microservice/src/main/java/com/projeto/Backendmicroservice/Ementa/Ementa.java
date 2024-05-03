package com.projeto.Backendmicroservice.Ementa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ementa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate data;
    private String nomeSopa;
    private double quantidade;

    public Ementa(LocalDate data, String nomeSopa, double quantidade) {
        this.data = data;
        this.nomeSopa = nomeSopa;
        this.quantidade = quantidade;
    }
}
