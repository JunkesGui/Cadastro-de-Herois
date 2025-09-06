package com.JunkesGui.CadastroDeHerois.Herois;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private HeroiService heroiService;
    public HeroiController(HeroiService heroiService) {
        this.heroiService = heroiService;
    }

    //    Adicionar Heroi
    @PostMapping("/adicionar")
    public String criarHeroi(){
        return "Criado com sucesso!";
    }

//    Mostrar Heroi por ID
    @GetMapping("/todos/{id}")
    public HeroiModel mostrarHeroiPorID(@PathVariable long id){
    return heroiService.mostrarHeroiPorID(id);
}

//    Mostrar lista de Herois
    @GetMapping("/todos")
    public List<HeroiModel> mostrarListaHerois(){
        return heroiService.mostrarListaHerois();
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
