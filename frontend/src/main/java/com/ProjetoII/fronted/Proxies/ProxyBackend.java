package com.ProjetoII.fronted.Proxies;

import com.ProjetoII.fronted.DataTransferObjects.DadosRefeicaoDTO;
import com.ProjetoII.fronted.DataTransferObjects.EmentaDTO;
import com.ProjetoII.fronted.DataTransferObjects.RefeicaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name="Backend-microservice")
public interface ProxyBackend {

    @GetMapping("/visualizarMensal")
    public List<DadosRefeicaoDTO> getDadosByMes(@RequestParam("mes") int mes);

    @GetMapping("/visualizarMensal/total")
    public double getTotalLitrosMes(@RequestParam("mes") int mes);

    @GetMapping("/visualizar")
    public List<RefeicaoDTO> getAllData();

    @GetMapping("/visualizarData")
    public DadosRefeicaoDTO getDadosRefeicaoByDate(@RequestParam("data") LocalDate data);

    @GetMapping("/visualizarData/total")
    public Integer getTotalRefeicoes(@RequestParam("data") LocalDate data);

    @GetMapping("/visualizarData/total-com-sopa")
    public Integer getTotalRefeicoesComSopa(@RequestParam("data") LocalDate data);

    @GetMapping("/visualizarData/total-sem-sopa")
    public Integer getTotalRefeicoesSemSopa(@RequestParam("data") LocalDate data);

    /*Ementa*/
    @PostMapping("/ementas/inserir")
    public void insertEmenta(@RequestBody EmentaDTO ementa);

    @GetMapping("/ementas/visualizar")
    public List<EmentaDTO> getEmentas(@RequestParam("semana") String semana);
}
