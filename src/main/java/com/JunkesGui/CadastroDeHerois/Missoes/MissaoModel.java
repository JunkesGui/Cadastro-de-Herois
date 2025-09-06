package com.JunkesGui.CadastroDeHerois.Missoes;

import com.JunkesGui.CadastroDeHerois.Herois.HeroiModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //Uma missao, varios herois
    @OneToMany(mappedBy = "missao")
    @JsonIgnore
    private List<HeroiModel> herois;
}
