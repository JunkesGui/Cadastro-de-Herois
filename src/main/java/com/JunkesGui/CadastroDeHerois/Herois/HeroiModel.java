package com.JunkesGui.CadastroDeHerois.Herois;

import com.JunkesGui.CadastroDeHerois.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroiModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String classe;
    private short rank;

    //Varios herois, uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissaoModel missao;
}
