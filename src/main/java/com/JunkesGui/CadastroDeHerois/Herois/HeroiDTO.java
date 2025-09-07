package com.JunkesGui.CadastroDeHerois.Herois;

import com.JunkesGui.CadastroDeHerois.Missoes.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroiDTO {

    private Long id;
    private String nome;
    private String classe;
    private short rank;
    private String equipamento;
    private MissaoModel missao;
}
