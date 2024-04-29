package com.projeto.Backendmicroservice;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class DadosController {

    private final RepositorioRefeicoes repositorioRefeicoes;
    private final GestorDadosService gestorDadosService;

    /*Tabelas*/
    @GetMapping("/visualizarMensal")
    public List<DadosRefeicao> getDadosByMes(@RequestParam("mes") int mes){
        return gestorDadosService.obterTotalSopaMes(mes);
    }

    @GetMapping("/visualizarMensal/total")
    public double getTotalLitrosMes(@RequestParam("mes") int mes){
       return repositorioRefeicoes.countLitrosPorMes(mes);
    }

    @GetMapping("/visualizar")
    public List<Refeicao> getAllData(){
        return repositorioRefeicoes.findAll(Sort.by("data").ascending());
    }

    @GetMapping("/visualizarData")
    public DadosRefeicao getDadosRefeicaoByDate(@RequestParam("data") LocalDate data){
        return gestorDadosService.obterTotalSopa(data);
    }

    @GetMapping("/visualizarData/total")
    public Integer getTotalRefeicoes(@RequestParam("data") LocalDate data){
        return repositorioRefeicoes.countTotalRefeicoesPorDia(data);
    }

    /*Gráficos*/




}
