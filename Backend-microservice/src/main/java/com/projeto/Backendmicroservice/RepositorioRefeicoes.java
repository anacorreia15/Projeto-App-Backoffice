package com.projeto.Backendmicroservice;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioRefeicoes extends JpaRepository<Refeicao, Integer> {
}