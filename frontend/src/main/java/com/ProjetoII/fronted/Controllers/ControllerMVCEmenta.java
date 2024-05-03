package com.ProjetoII.fronted.Controllers;

import com.ProjetoII.fronted.DataTransferObjects.EmentaDTO;
import com.ProjetoII.fronted.Proxies.ProxyBackend;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ControllerMVCEmenta {

    private final ProxyBackend proxyBackend;

    @GetMapping("/ementas")
    public String getEmentasPage(){
        return "ementas";
    }

    @PostMapping("/ementas/inserir")
    public String insertEmenta(@ModelAttribute EmentaDTO ementa) {
        proxyBackend.insertEmenta(ementa);
        return "ementas";
    }

    @GetMapping("/ementas/visualizar")
    public String getEmentasSemana(@RequestParam("semana") String semana, Model model){
        model.addAttribute("ementas", proxyBackend.getEmentas(semana));
        return "ementas";
    }
}
