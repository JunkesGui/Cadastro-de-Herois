package com.JunkesGui.CadastroDeHerois.Herois;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroiService {

    private HeroiRepository heroiRepository;
    private HeroiMapper heroiMapper;

    public HeroiService(HeroiRepository heroiRepository, HeroiMapper heroiMapper) {
        this.heroiRepository = heroiRepository;
        this.heroiMapper = heroiMapper;
    }

//    Mostrar todos os herois
    public List<HeroiDTO> mostrarListaHerois(){
        List<HeroiModel> herois = heroiRepository.findAll();
        return herois.stream()
                .map(heroiMapper::map)
                .collect(Collectors.toList());
    }

//    Mostrar heroi por id
    public HeroiDTO mostrarHeroiPorID(long id){
        Optional<HeroiModel> heroi = heroiRepository.findById(id);
        return heroi.map(heroiMapper::map).orElse(null);
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
    public HeroiDTO alterarHeroiID(long id, HeroiDTO heroiUpdated){
        Optional<HeroiModel> heroi = heroiRepository.findById(id);
        if(heroi.isPresent()){
            HeroiModel heroiModel = heroiMapper.map(heroiUpdated);
            heroiModel.setId(id);
            HeroiModel heroiSalvo = heroiRepository.save(heroiModel);
            return heroiMapper.map(heroiSalvo);
        }
        return null;
    }
}
