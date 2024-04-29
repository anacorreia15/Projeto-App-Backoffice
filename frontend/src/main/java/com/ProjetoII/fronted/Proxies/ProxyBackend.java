package com.ProjetoII.fronted.Proxies;

import com.ProjetoII.fronted.DataTransferObjects.DadosRefeicaoDTO;
import com.ProjetoII.fronted.DataTransferObjects.RefeicaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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


}
