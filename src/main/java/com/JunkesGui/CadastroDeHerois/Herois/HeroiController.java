package com.JunkesGui.CadastroDeHerois.Herois;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HeroiController {

    @GetMapping("/boasvindas")
    public String BemVindo() {
        return "Bem Vindo a essa rota!";
    }

}
