package com.projeto.Backendmicroservice;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class DadosController {

    private final RepositorioRefeicoes repositorioRefeicoes;

    /*Tabelas*/
    @GetMapping("/visualizarMensal")
    public List<Refeicao> getDataByMes(@RequestParam("mes") int mes){
        return repositorioRefeicoes.findRefeicoesByMesAndTigela(mes);
    }

    @GetMapping("/visualizar")
    public List<Refeicao> getAllData(){
        return repositorioRefeicoes.findAll(Sort.by("data").ascending());
    }

    @GetMapping("/visualizarData")
    public List<Refeicao> getDataByDate(@RequestParam("data") LocalDate data){
        return repositorioRefeicoes.findRefeicoesByDataAndTigela(data);
    }

    /*Gráficos*/
    @GetMapping("/total-mensal")
    public Optional<Integer> getTotaisMes(){
        return repositorioRefeicoes.findTotalSopaPorMes(LocalDate.now().getMonthValue());
    }



}
