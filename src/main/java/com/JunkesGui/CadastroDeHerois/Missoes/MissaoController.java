package com.JunkesGui.CadastroDeHerois.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/adicionar")
    @Operation(summary = "Criar Missao",
            description = "Rota para cadastro de missoes na tabela TB_MISSOES")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Missao cadastrada com sucesso!\n {nome}")
    })
    public ResponseEntity<String> adicionarMissao(@RequestBody MissaoDTO missaoDTO) {
        MissaoDTO missao = missaoService.cadastrarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao cadastrada com sucesso!\n" + missao.getNome());
    }

    @GetMapping("/todos/{id}")
    @Operation(summary = "Buscar Missao por ID",
            description = "Rota para buscar uma missao por ID na tabela TB_MISSOES")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "{missao JSON}"),
            @ApiResponse(responseCode = "404",
                    description = "Id {id} nao encontrado!")
    })
    public ResponseEntity<?> mostrarMissaoPorId(@PathVariable long id) {
        if(missaoService.mostrarMissaoPorId(id)!=null) {
            MissaoDTO missaoDTO = missaoService.mostrarMissaoPorId(id);
            return ResponseEntity.ok(missaoDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id "+ id+" nao encontrado!");
        }
    }

    @GetMapping("/todos")
    @Operation(summary = "Mostra a lista completa de Missoes",
            description = "Rota para mostrar toda a lista TB_MISSOES")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "{TB_CADASTRO} JSON")
    })
    public ResponseEntity<List<MissaoDTO>> mostrarMissoes(){
        List<MissaoDTO> listaMissoes = missaoService.mostrarListaMissoes();
        return ResponseEntity.ok(listaMissoes);
    }

    @PutMapping("/alterarid/{id}")
    @Operation(summary = "Altera dados de uma missao por ID",
            description = "Recebe um ID na rota e um JSON para alterar uma Missao da TB_MISSOES")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Missao de ID {id} alterada com sucesso!"),
            @ApiResponse(responseCode = "404",
                    description = "Id {id} nao encontrado!")
    })
    public ResponseEntity<String> alterarMissaoID(@PathVariable long id, @RequestBody MissaoDTO missaoDTO) {
        if (missaoService.mostrarMissaoPorId(id)!=null) {
            missaoService.atualizarMissaoID(id, missaoDTO);
            return ResponseEntity.ok("Missao de ID " + id + " alterada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id "+ id+" nao encontrado!");
        }
    }

    @DeleteMapping("/apagar/{id}")
    @Operation(summary = "Deleta uma missao por ID",
            description = "Recebe um ID na rota e deleta uma missao da tabela TB_MISSOES")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Missao de ID {id} apagada com sucesso!"),
            @ApiResponse(responseCode = "404",
                    description = "Id {id} nao encontrado!")
    })
    public ResponseEntity<String> apagarMissaoID(@PathVariable long id){
        if(missaoService.mostrarMissaoPorId(id)!=null) {
            String missaoName = missaoService.mostrarMissaoPorId(id).getNome();
            missaoService.apagarMissao(id);
            return ResponseEntity.ok("Missao de ID " + id + " apagada com sucesso!\n" +
                    "("+missaoName+")");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id "+ id+" nao encontrado!");
        }
    }
}
