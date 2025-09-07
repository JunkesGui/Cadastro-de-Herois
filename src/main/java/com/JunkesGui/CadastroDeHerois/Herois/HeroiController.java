package com.JunkesGui.CadastroDeHerois.Herois;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private HeroiService heroiService;
    public HeroiController(HeroiService heroiService) {
        this.heroiService = heroiService;
    }

//    Adicionar Heroi
    @PostMapping("/adicionar")
    public HeroiDTO criarHeroi(@RequestBody HeroiDTO heroi){
        return heroiService.criarHeroi(heroi);
    }

//    Mostrar Heroi por ID
    @GetMapping("/todos/{id}")
    public HeroiDTO mostrarHeroiPorID(@PathVariable long id){
    return heroiService.mostrarHeroiPorID(id);
}

//    Mostrar lista de Herois
    @GetMapping("/todos")
    public List<HeroiDTO> mostrarListaHerois(){
        return heroiService.mostrarListaHerois();
    }

//    Alterar dados de Heroi
    @PutMapping("/alterarid/{id}")
    public HeroiDTO alterarHeroiID(@PathVariable long id, @RequestBody HeroiDTO heroiUpdated){
        return heroiService.alterarHeroiID(id, heroiUpdated);
    }

//    Deletar Heroi
    @DeleteMapping("/apagar/{id}")
    public void apagarHeroiID(@PathVariable long id){
       heroiService.apagarHeroiID(id);
    }

}
