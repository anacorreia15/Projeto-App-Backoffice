package com.ProjetoII.fronted.Proxies;

import com.ProjetoII.fronted.DataTransferObjects.RefeicaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="Backend-microservice")
public interface ProxyBackend {

    @GetMapping("/visualizar")
    public List<RefeicaoDTO> getData();
}
