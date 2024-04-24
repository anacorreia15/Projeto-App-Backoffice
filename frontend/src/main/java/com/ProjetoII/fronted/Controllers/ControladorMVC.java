package com.ProjetoII.fronted.Controllers;

import com.ProjetoII.fronted.Proxies.ProxyBackend;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ControladorMVC {

    private final ProxyBackend proxyBackend;
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping({"/visualizar"})
    public String getData(Model model){
        model.addAttribute("dados", proxyBackend.getData());
        return "index";
    }


}
