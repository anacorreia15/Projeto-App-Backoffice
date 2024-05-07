package com.ProjetoII.fronted.Controllers;

import com.ProjetoII.fronted.ProxyBackend;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/estatisticas/graficoMensal")
    public String getGraficosMensais(@RequestParam("mes") int mes, Model model){

        String mesSelecionado = "";
        switch (mes) {
            case 1: mesSelecionado = "Janeiro"; break;
            case 2: mesSelecionado = "Fevereiro"; break;
            case 3: mesSelecionado = "Março"; break;
            case 4: mesSelecionado = "Abril"; break;
            case 5: mesSelecionado = "Maio"; break;
            // Adicione os outros meses conforme necessário
        }

        model.addAttribute("totaisRefeicoesComSopa", proxyBackend.getTotalMensalRefeicoesComSopa(mes));
        model.addAttribute("totaisRefeicoesSemSopa", proxyBackend.getTotalMensalRefeicoesSemSopa(mes));
        model.addAttribute("mesSelecionado", mesSelecionado);
        model.addAttribute("volumeSopaSemanas", proxyBackend.getTotalSopaDesperdicadaSemanas(mes));
        model.addAttribute("volumeSopaDiario", proxyBackend.getLitrosDesperdicadosPorDia(mes));
        model.addAttribute("sopaDesperdicada", proxyBackend.getTotalSopaDesperdicadaMes(mes));
        model.addAttribute("sopaProduzida", proxyBackend.getTotalSopaProdMes(mes));
        return "graficos-mensal";
    }

    @GetMapping("/estatisticas/graficosVariados")
    public String getOutrosGraficos(Model model){
        List<String> listaMeses = Arrays.asList("Janeiro", "Fevereiro", "Março", "Abril", "Maio");
        model.addAttribute("dadosVariosMeses", proxyBackend.getTotalSopaDesperdicada());
        model.addAttribute("listaMeses", listaMeses);
        model.addAttribute("nrRefeicoes", proxyBackend.getNrRefeicoesMes());
        model.addAttribute("nrRefeicoesTigela", proxyBackend.getNrRefeicoesComTigelaMes());
        return "outros-graficos";
    }



}
