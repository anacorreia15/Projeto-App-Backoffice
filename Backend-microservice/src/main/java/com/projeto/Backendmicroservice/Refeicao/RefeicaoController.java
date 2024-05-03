package com.projeto.Backendmicroservice.Refeicao;

import com.projeto.Backendmicroservice.Ementa.Ementa;
import com.projeto.Backendmicroservice.Ementa.RepositorioEmentas;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class RefeicaoController {

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

    @GetMapping("/visualizarData/total-com-sopa")
    public Integer getTotalRefeicoesComSopa(@RequestParam("data") LocalDate data){
        return repositorioRefeicoes.countTotalRefeicoesPorDiaComTigela(data);
    }
    @GetMapping("/visualizarData/total-sem-sopa")
    public Integer getTotalRefeicoesSemSopa(@RequestParam("data") LocalDate data){
        return repositorioRefeicoes.countTotalRefeicoesPorDiaSemTigela(data);
    }


    /*Gráficos*/




}
