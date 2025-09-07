package com.JunkesGui.CadastroDeHerois.Herois;

import org.springframework.stereotype.Component;

@Component
public class HeroiMapper {

    public HeroiModel map(HeroiDTO heroiDTO) {
        HeroiModel heroiModel = new HeroiModel();

        heroiModel.setId(heroiDTO.getId());
        heroiModel.setNome(heroiDTO.getNome());
        heroiModel.setClasse(heroiDTO.getClasse());
        heroiModel.setRank(heroiDTO.getRank());
        heroiModel.setEquipamento(heroiDTO.getEquipamento());
        heroiModel.setMissao(heroiDTO.getMissao());

        return heroiModel;
    }

    public HeroiDTO map(HeroiModel heroiModel) {
        HeroiDTO heroiDTO = new HeroiDTO();

        heroiDTO.setId(heroiModel.getId());
        heroiDTO.setNome(heroiModel.getNome());
        heroiDTO.setClasse(heroiModel.getClasse());
        heroiDTO.setRank(heroiModel.getRank());
        heroiDTO.setEquipamento(heroiModel.getEquipamento());
        heroiDTO.setMissao(heroiModel.getMissao());

        return heroiDTO;
    }

}
