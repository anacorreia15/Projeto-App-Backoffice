package com.projeto.Backendmicroservice.Refeicao;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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

    @GetMapping("/visualizarMensal/total-refeicoes")
    public Integer getTotalMensalRefeicoes(@RequestParam("mes") int mes){
        return repositorioRefeicoes.countTotalRefeicoesPorMes(mes);
    }

    @GetMapping("/visualizarMensal/total-com-sopa")
    public Integer getTotalMensalRefeicoesComSopa(@RequestParam("mes") int mes){
        return repositorioRefeicoes.countTotalRefeicoesPorMesComTigela(mes);
    }

    @GetMapping("/visualizarMensal/total-sem-sopa")
    public Integer getTotalMensalRefeicoesSemSopa(@RequestParam("mes") int mes){
        return repositorioRefeicoes.countTotalRefeicoesPorMesSemTigela(mes);
    }

    @GetMapping("/visualizar")
    public List<Refeicao> getAllData(){
        return repositorioRefeicoes.findAllRefeicoes();
    }

    @GetMapping("/visualizarData")
    public List<DadosRefeicao> getDadosRefeicaoByDate(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
        return gestorDadosService.obterTotalSopa(data);
    }

    @GetMapping("/visualizarData/total")
    public Integer getTotalRefeicoes(@RequestParam("data")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
        return repositorioRefeicoes.countTotalRefeicoesPorDia(data);
    }

    @GetMapping("/visualizarData/total-com-sopa")
    public Integer getTotalRefeicoesComSopa(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
        return repositorioRefeicoes.countTotalRefeicoesPorDiaComTigela(data);
    }
    @GetMapping("/visualizarData/total-sem-sopa")
    public Integer getTotalRefeicoesSemSopa(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
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
    public List<Double> getTotalSopaDesperdicadaSemanas(@RequestParam("mes") Integer mes){
        return gestorDadosService.getTotalSopaDesperdicadaSemanas(mes);
    }

    @GetMapping("/estatisticas/volume-desperdicado-mes")
    public List<DadosRefeicao> getLitrosDesperdicadosPorDia(@RequestParam("mes") Integer mes){
        return gestorDadosService.obterTotalSopaMes(mes);
    }

    //volume total de sopa desperdicada dos vários meses
    @GetMapping("/estatisticas/total-volume-desperdicado-mes")
    public List<Double> getTotalSopaDesperdicada(){
        return gestorDadosService.getTotalSopaDesperdicadaMes();
    }

    @GetMapping("/estatisticas/total-refeicoes-mes")
    public List<Integer> getNrRefeicoesMes(){
        return gestorDadosService.getNrRefeicoesMes();
    }

    @GetMapping("/estatisticas/total-refeicoes-mes-tigela")
    public List<Integer> getNrRefeicoesComTigelaMes(){
        return gestorDadosService.getNrRefeicoesMesComTigela();
    }

    @GetMapping("/estatisticas/total-sopa-desperdicada")
    public Double getTotalSopaDesperdicadaMes(@RequestParam("mes") Integer mes){
        return repositorioRefeicoes.calculaLitrosDesperdicadosPorMes(mes);
    }



}
