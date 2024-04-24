package com.projeto.Backendmicroservice;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DadosController {

    private final RepositorioRefeicoes repositorioRefeicoes;

    @GetMapping("/visualizar")
    public List<Refeicao> getData(){
        return repositorioRefeicoes.findAll();
    }
}
