package com.JunkesGui.CadastroDeHerois.Herois;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroiService {

    private HeroiRepository heroiRepository;
    public HeroiService(HeroiRepository heroiRepository) {
        this.heroiRepository = heroiRepository;
    }

//    Mostrar todos os herois
    public List<HeroiModel> mostrarListaHerois(){
        return heroiRepository.findAll();
    }

//    Mostrar heroi por id
    public HeroiModel mostrarHeroiPorID(long id){
        Optional<HeroiModel> heroi = heroiRepository.findById(id);
        return heroi.orElse(null);
    }

//    Criar novo heroi
    public HeroiModel criarHeroi(HeroiModel heroi){
        return heroiRepository.save(heroi);
    }

//    Deletar heroi por ID
    public void apagarHeroiID(long id){
        heroiRepository.deleteById(id);
    }

}
