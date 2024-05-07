package com.projeto.Backendmicroservice.Refeicao;

import com.projeto.Backendmicroservice.Ementa.Ementa;
import com.projeto.Backendmicroservice.Ementa.RepositorioEmentas;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@SuppressWarnings("LanguageDetectionInspection")
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

    @GetMapping("/visualizarMensal/total-refeicoes")
    public Integer getTotalMensalRefeicoes(@RequestParam("mes") int mes){
        return repositorioRefeicoes.countTotalRefeicoesPorMes(mes);
    }

    @GetMapping("/visualizarMensal/total-com-sopa")
    public Integer getTotalMensalRefeicoesComSopa(@RequestParam("mes") int mes){
        return repositorioRefeicoes.countTotalRefeicoesPorMesComTigela(mes);
    }

    @GetMapping("/visualizar")
    public List<Refeicao> getAllData(){
        return repositorioRefeicoes.findAllRefeicoes();
    }

    @GetMapping("/visualizarData")
    public List<DadosRefeicao> getDadosRefeicaoByDate(@RequestParam("data") LocalDate data){
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
    @GetMapping("/estatisticas/total-com-sopa-semanal")
    public Integer getTotalRefeicoesComSopaPorSemana(@RequestParam("semana") String semana){
        return gestorDadosService.getDadosTotaisComSopa(semana);
    }
    @GetMapping("/estatisticas/total-sem-sopa-semanal")
    public Integer getTotalRefeicoesSemSopaPorSemana(@RequestParam("semana") String semana){
        return gestorDadosService.getDadosTotaisSemSopa(semana);
    }

    @GetMapping("/estatisticas/volume-desperdicado-semana")
    public List<DadosRefeicao> getSopaDesperdicadaPorSemana(@RequestParam("semana") String semana){
        return gestorDadosService.obterTotalSopaSemana(semana);
    }

    @GetMapping("/estatisticas/total-volume-desperdicado-semana")
    public Double getTotalSopaDesperdicadaPorSemana(@RequestParam("semana") String semana){
        return gestorDadosService.getTotalSopaDesperdicadaSemana(semana);
    }

    @GetMapping("/estatisticas/total-volume-desperdicado-mes")
    public Double getTotalSopaDesperdicadaPorMes(@RequestParam("mes") Integer mes){
        return gestorDadosService.getTotalSopaDesperdicadaMes(mes);
    }

}
