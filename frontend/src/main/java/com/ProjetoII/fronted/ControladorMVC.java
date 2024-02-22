package com.ProjetoII.fronted;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorMVC {

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }
}
