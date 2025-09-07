package com.JunkesGui.CadastroDeHerois.Herois;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroiService {

    private HeroiRepository heroiRepository;
    private HeroiMapper heroiMapper;

    public HeroiService(HeroiRepository heroiRepository, HeroiMapper heroiMapper) {
        this.heroiRepository = heroiRepository;
        this.heroiMapper = heroiMapper;
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
    public HeroiDTO criarHeroi(HeroiDTO heroiDTO){
        HeroiModel heroi = heroiMapper.map(heroiDTO);
        heroi = heroiRepository.save(heroi);
        return heroiMapper.map(heroi);
    }

//    Deletar heroi por ID
    public void apagarHeroiID(long id){
        heroiRepository.deleteById(id);
    }

//    Modificar heroi por ID
    public HeroiModel alterarHeroiID(long id, HeroiModel heroiUpdated){
        if(heroiRepository.existsById(id)){
            heroiUpdated.setId(id);
            return heroiRepository.save(heroiUpdated);
        }
        return null;
    }
}
