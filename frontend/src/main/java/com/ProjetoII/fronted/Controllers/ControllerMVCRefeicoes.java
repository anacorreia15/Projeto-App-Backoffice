package com.ProjetoII.fronted.Controllers;

import com.ProjetoII.fronted.Proxies.ProxyBackend;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class ControllerMVCRefeicoes {

    private final ProxyBackend proxyBackend;
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/estatisticas")
    public String getGraficosPage(){
        return "graficos";
    }

    @GetMapping("/sobre")
    public String getAboutPage(){
        return "sobre";
    }

    @GetMapping({"/geral/visualizarMensal"})
    public String getData(@RequestParam("mes") int mes,Model model){
        model.addAttribute("dados", proxyBackend.getDadosByMes(mes));
        model.addAttribute("totais", proxyBackend.getTotalLitrosMes(mes));
        return "index";
    }

    @GetMapping("/geral/visualizar")
    public String getAllData(Model model){
        model.addAttribute("dados", proxyBackend.getAllData());
        return "index";
    }

    @GetMapping("/geral/visualizarData")
    public String getDataByDate(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data, Model model){
        model.addAttribute("dados", proxyBackend.getDadosRefeicaoByDate(data));
        model.addAttribute("totalRefeicoes", proxyBackend.getTotalRefeicoes(data));
        model.addAttribute("totalRefeicoesComSopa", proxyBackend.getTotalRefeicoesComSopa(data));
        model.addAttribute("totalRefeicoesSemSopa", proxyBackend.getTotalRefeicoesSemSopa(data));
        return "index";
    }



}
