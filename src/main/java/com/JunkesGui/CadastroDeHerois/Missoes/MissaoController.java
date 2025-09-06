package com.JunkesGui.CadastroDeHerois.Missoes;

import com.JunkesGui.CadastroDeHerois.Herois.HeroiModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

//    Criar Missao
    @PostMapping("/adicionar")
    public String adicionarMissao(){
        return "Adicionado com sucesso!";
    }

//    Mostrar Missao por ID
    @GetMapping("/todosid")
    public String mostrarMissaoPorId(){
        return "Id missao";
    }

//    Mostrar todas as Missoes
    @GetMapping("/todos")
    public String mostrarMissoes(){
        return "Lista de missoes";
    }

//    Alterar Missao por ID
    @PutMapping("/alterarid")
    public String alterarMissaoID(){
        return "Alterado com sucesso!";
    }

//    Apagar Missao por ID
    @DeleteMapping("/apagar")
    public String apagarMissaoID(){
        return "Apagado com sucesso!";
    }
}
