package com.JunkesGui.CadastroDeHerois.Herois;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping("/adicionar")
    @Operation(summary = "Criar Heroi",
            description = "Rota para criacao de herois novos na tabela TB_CADASTRO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Heroi criado com sucesso!\n ID: {id} Nome: {nome}")
    })
    public ResponseEntity<String> criarHeroi(@RequestBody HeroiDTO heroi){
        HeroiDTO heroiDTO = heroiService.criarHeroi(heroi);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Heroi criado com sucesso!\n" + "ID: " + heroiDTO.getId() + " Nome: " + heroiDTO.getNome());
    }

    @GetMapping("/todos/{id}")
    @Operation(summary = "Buscar Heroi por ID",
            description = "Rota para busca de heroi por um ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "{heroi JSON}"),
            @ApiResponse(responseCode = "404",
                    description = "Id {id} nao encontrado!")
    })
    public ResponseEntity<?> mostrarHeroiPorID(@PathVariable long id){
        if (heroiService.mostrarHeroiPorID(id) != null) {
            HeroiDTO heroi = heroiService.mostrarHeroiPorID(id);
            return ResponseEntity.ok(heroi);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id "+id+" nao encontrado!");
        }
}

    @GetMapping("/todos")
    @Operation(summary = "Mostra a lista completa de Herois",
            description = "Rota para mostrar a tabela completa TB_CADASTRO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "{TB_CADASTRO JSON}")
    })
    public ResponseEntity<List<HeroiDTO>> mostrarListaHerois(){
        List<HeroiDTO> listaHerois = heroiService.mostrarListaHerois();
        return ResponseEntity.status(HttpStatus.OK).body(listaHerois);
    }

    @PutMapping("/alterarid/{id}")
    @Operation(summary = "Altera dados de um Heroi por ID",
            description = "Rota que recebe um ID e um JSON para alterar um Heroi cadastrado na tabela TB_CADASTRO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Heroi de  ID {id} alterado com sucesso!"),
            @ApiResponse(responseCode = "404",
                    description = "Id {id} nao encontrado!")
    })
    public ResponseEntity<String> alterarHeroiID(@PathVariable long id, @RequestBody HeroiDTO heroiUpdated){
        if (heroiService.mostrarHeroiPorID(id) != null) {
            heroiService.alterarHeroiID(id, heroiUpdated);
            return ResponseEntity.ok("Heroi de ID "+id+" alterado com sucesso!\n");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id "+id+" nao encontrado!");
        }
    }

//    Deletar Heroi
    @DeleteMapping("/apagar/{id}")
    @Operation(summary = "Deleta um Heroi por ID",
            description = "Rota para deletar um heroi da tabela TB_CADASTRO por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Heroi de id {id} deletado com sucesso!"),
            @ApiResponse(responseCode = "404",
                    description = "Id {id} nao encontrado!")
    })
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
