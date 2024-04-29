package com.ProjetoII.fronted.Controllers;

import com.ProjetoII.fronted.DataTransferObjects.RefeicaoDTO;
import com.ProjetoII.fronted.Proxies.ProxyBackend;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class ControladorMVC {

    private final ProxyBackend proxyBackend;
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/ementas")
    public String getEmentasPage(){
        return "ementas";
    }

    @GetMapping("/graficos")
    public String getGraficosPage(){
        return "graficos";
    }

    @GetMapping("/sobre")
    public String getAboutPage(){
        return "sobre";
    }

    @GetMapping({"/visualizarMensal"})
    public String getData(@RequestParam("mes") int mes,Model model){
        model.addAttribute("dados", proxyBackend.getDadosByMes(mes));
        model.addAttribute("totais", proxyBackend.getTotalLitrosMes(mes));
        return "index";
    }
    /*@GetMapping({"/visualizarMensal/total"})
    public String getTotais(@RequestParam("mes") int mes,Model model) {

        return "index";
    }*/

    @GetMapping("/visualizar")
    public String getAllData(Model model){
        model.addAttribute("dados", proxyBackend.getAllData());
        return "index";
    }

    @GetMapping("/visualizarData")
    public String getDataByDate(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data, Model model){
        model.addAttribute("dados", proxyBackend.getDadosRefeicaoByDate(data));
        return "index";
    }

    @GetMapping("/visualizarData/total")
    public String getTotais(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data, Model model){
        model.addAttribute("totais", proxyBackend.getTotalRefeicoes(data));
        return "index";
    }



}
