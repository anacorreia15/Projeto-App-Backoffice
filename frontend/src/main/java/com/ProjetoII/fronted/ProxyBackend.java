package com.ProjetoII.fronted;

import com.ProjetoII.fronted.DataTransferObjects.DadosRefeicaoDTO;
import com.ProjetoII.fronted.DataTransferObjects.EmentaDTO;
import com.ProjetoII.fronted.DataTransferObjects.RefeicaoDTO;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.zip.DataFormatException;

@FeignClient(name="Backend-microservice")
public interface ProxyBackend {

    @GetMapping("/visualizarMensal")
    public List<DadosRefeicaoDTO> getDadosByMes(@RequestParam("mes") int mes);

    @GetMapping("/visualizarMensal/total")
    public double getTotalLitrosMes(@RequestParam("mes") int mes);

    @GetMapping("/visualizarMensal/total-refeicoes")
    public Integer getTotalMensalRefeicoes(@RequestParam("mes") int mes);
    @GetMapping("/visualizarMensal/total-com-sopa")
    public Integer getTotalMensalRefeicoesComSopa(@RequestParam("mes") int mes);

    @GetMapping("/visualizarMensal/total-sem-sopa")
    public Integer getTotalMensalRefeicoesSemSopa(@RequestParam("mes") int mes);

    @GetMapping("/visualizar")
    public List<RefeicaoDTO> getAllData();

    @GetMapping("/visualizarData")
    public List<DadosRefeicaoDTO> getDadosRefeicaoByDate(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data);

    @GetMapping("/visualizarData/total")
    public Integer getTotalRefeicoes(@RequestParam("data") @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate data);

    @GetMapping("/visualizarData/total-com-sopa")
    public Integer getTotalRefeicoesComSopa(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data);

    @GetMapping("/visualizarData/total-sem-sopa")
    public Integer getTotalRefeicoesSemSopa(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data);

    @GetMapping("/visualizarData/sopaProd")
    public DadosRefeicaoDTO getTotalSopaProd(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data);

    /*Ementa*/
    @PostMapping("/ementas/inserir")
    public void insertEmenta(@RequestBody EmentaDTO ementa);

    @GetMapping("/ementas/visualizar")
    public List<EmentaDTO> getEmentas(@RequestParam("semana") String semana);

    /*Graficos*/
    @GetMapping("/estatisticas/total-com-sopa-semanal")
    public Integer getTotalRefeicoesComSopaPorSemana(@RequestParam("semana") String semana);

    @GetMapping("/estatisticas/total-sem-sopa-semanal")
    public Integer getTotalRefeicoesSemSopaPorSemana(@RequestParam("semana") String semana);

    @GetMapping("/estatisticas/volume-desperdicado-semana")
    public List<DadosRefeicaoDTO> getSopaDesperdicadaPorSemana(@RequestParam("semana") String semana);

    @GetMapping("/estatisticas/total-volume-desperdicado-semana")
    public List<Double> getTotalSopaDesperdicadaSemanas(@RequestParam("mes") Integer mes);

    @GetMapping("/estatisticas/volume-desperdicado-mes")
    public List<DadosRefeicaoDTO> getLitrosDesperdicadosPorDia(@RequestParam("mes") Integer mes);

    @GetMapping("/estatisticas/total-volume-desperdicado-mes")
    public List<Double> getTotalSopaDesperdicada();

    @GetMapping("/estatisticas/total-refeicoes-mes")
    public List<Integer> getNrRefeicoesMes();

    @GetMapping("/estatisticas/total-refeicoes-mes-tigela")
    public List<Integer> getNrRefeicoesComTigelaMes();

    @GetMapping("/estatisticas/total-sopa-desperdicada")
    public Double getTotalSopaDesperdicadaMes(@RequestParam("mes") Integer mes);

    @GetMapping("/estatisticas/total-sopa-produzuida")
    public Double getTotalSopaProdMes(@RequestParam("mes") Integer mes);

}
