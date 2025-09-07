package com.JunkesGui.CadastroDeHerois.Missoes;

import com.JunkesGui.CadastroDeHerois.Herois.HeroiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<HeroiModel> herois;
}
