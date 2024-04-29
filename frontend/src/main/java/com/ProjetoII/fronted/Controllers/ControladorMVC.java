package com.ProjetoII.fronted.Controllers;

import com.ProjetoII.fronted.DataTransferObjects.RefeicaoDTO;
import com.ProjetoII.fronted.Proxies.ProxyBackend;
import lombok.AllArgsConstructor;
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
        model.addAttribute("dados", proxyBackend.getDataByMes(mes));
        return "index";
    }

    @GetMapping("/visualizar")
    public String getAllData(Model model){
        model.addAttribute("dados", proxyBackend.getAllData());
        return "index";
    }

    @GetMapping("/visualizarData")
    public String getDataByDate(@RequestParam("data") LocalDate data, Model model){
        model.addAttribute("dados", proxyBackend.getDataByDate(data));
        return "index";
    }

    @GetMapping("/total-mensal")
    public String getTotaisMes(Model model){
        model.addAttribute("totais", proxyBackend.getTotaisMes());
        return "index";
    }




}
