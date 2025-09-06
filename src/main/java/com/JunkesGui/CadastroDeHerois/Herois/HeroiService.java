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
    public Optional<HeroiModel> mostrarHeroiPorID(long id){
        return heroiRepository.findById(id);
    }
}
