package com.JunkesGui.CadastroDeHerois.Herois;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarHeroi(@RequestBody HeroiDTO heroi){
        HeroiDTO heroiDTO = heroiService.criarHeroi(heroi);
        return ResponseEntity.status(HttpStatus.CREATED).body("Heroi criado com sucesso!\n " +
                "ID: " + heroiDTO.getId() + " Nome: " + heroiDTO.getNome());
    }

//    Mostrar Heroi por ID
    @GetMapping("/todos/{id}")
    public ResponseEntity<?> mostrarHeroiPorID(@PathVariable long id){
        if (heroiService.mostrarHeroiPorID(id) != null) {
            HeroiDTO heroi = heroiService.mostrarHeroiPorID(id);
            return ResponseEntity.ok(heroi);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id "+id+" nao encontrado!");
        }
}

//    Mostrar lista de Herois
    @GetMapping("/todos")
    public ResponseEntity<List<HeroiDTO>> mostrarListaHerois(){
        List<HeroiDTO> listaHerois = heroiService.mostrarListaHerois();
        return ResponseEntity.status(HttpStatus.OK).body(listaHerois);
    }

//    Alterar dados de Heroi
    @PutMapping("/alterarid/{id}")
    public ResponseEntity<String> alterarHeroiID(@PathVariable long id, @RequestBody HeroiDTO heroiUpdated){
        if (heroiService.mostrarHeroiPorID(id) != null) {
            heroiService.alterarHeroiID(id, heroiUpdated);
            return ResponseEntity.ok("Heroi de ID "+id+"alterado com sucesso!\n");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id "+id+" nao encontrado!");
        }
    }

//    Deletar Heroi
    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<String> apagarHeroiID(@PathVariable long id){
       if (heroiService.mostrarHeroiPorID(id) != null) {
           String heroiName = heroiService.mostrarHeroiPorID(id).getNome();
           heroiService.apagarHeroiID(id);
           return ResponseEntity.ok("Heroi de id "+ id + " deletado com sucesso!\n"+
                   "("+heroiName+")");
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Id "+id+" nao encontrado!");
       }

    }

}
