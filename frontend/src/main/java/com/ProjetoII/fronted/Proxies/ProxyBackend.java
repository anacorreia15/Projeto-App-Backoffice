package com.ProjetoII.fronted.Proxies;

import com.ProjetoII.fronted.DataTransferObjects.RefeicaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name="Backend-microservice")
public interface ProxyBackend {

    @GetMapping("/visualizarMensal")
    public List<RefeicaoDTO> getDataByMes(@RequestParam("mes") int mes);

    @GetMapping("/visualizar")
    public List<RefeicaoDTO> getAllData();

    @GetMapping("/visualizarData")
    public List<RefeicaoDTO> getDataByDate(@RequestParam("data") LocalDate data);

    @GetMapping("/total-mensal")
    public List<RefeicaoDTO> getTotaisMes();


}
