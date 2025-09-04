package com.JunkesGui.CadastroDeHerois;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class HeroiModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String Classe;
    private short Rank;

    public HeroiModel() {
    }

    public HeroiModel(String nome, String classe, short rank) {
        this.nome = nome;
        Classe = classe;
        Rank = rank;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public short getRank() {
        return Rank;
    }

    public void setRank(short rank) {
        Rank = rank;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
