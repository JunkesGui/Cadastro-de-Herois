package com.JunkesGui.CadastroDeHerois.Herois;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/herois")
public class HeroiController {

//    Adicionar Heroi
    @PostMapping("/adicionar")
    public String criarHeroi(){
        return "Criado com sucesso!";
    }

//    Mostrar Heroi por ID
    @GetMapping("/todosid")
    public String mostrarHeroiPorID(){
    return "HeroiID";
}

//    Mostrar lista de Herois
    @GetMapping("/todos")
    public String mostrarListaHerois(){
        return "Lista de Herois";
    }

//    Alterar dados de Heroi
    @PutMapping("/alterarid")
    public String alterarHeroiID(){
        return "Alterado com sucesso!";
    }

//    Deletar Heroi
    @DeleteMapping("/apagarid")
    public String apagarHeroiID(){
        return "Apagado com sucesso!";
    }

}
