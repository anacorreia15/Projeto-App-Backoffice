package com.ProjetoII.fronted.Controllers;

import com.ProjetoII.fronted.ProxyBackend;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ControllerMVCEstatisticas {

    ProxyBackend proxyBackend;

    @GetMapping("/estatisticas")
    public String getGraficosPage(){
        return "graficos";
    }

    @GetMapping("/estatisticas/total-semanal")
    public String getTotalRefeicoesPorSemana(@RequestParam("semana") String semana, Model model){
        model.addAttribute("comSopa", proxyBackend.getTotalRefeicoesComSopaPorSemana(semana));
        model.addAttribute("semSopa", proxyBackend.getTotalRefeicoesSemSopaPorSemana(semana));
        model.addAttribute("volumeDespSemanal", proxyBackend.getSopaDesperdicadaPorSemana(semana));
        return "graficos";
    }

}
