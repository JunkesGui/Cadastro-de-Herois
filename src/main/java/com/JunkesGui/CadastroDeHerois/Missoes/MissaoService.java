package com.JunkesGui.CadastroDeHerois.Missoes;

import com.JunkesGui.CadastroDeHerois.Herois.HeroiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

//    Mostrar todas as missoes
    public List<MissaoDTO> mostrarListaMissoes() {
        List<MissaoModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

//    Mostrar missao por ID
    public MissaoDTO mostrarMissaoPorId(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.map(missaoMapper::map).orElse(null);
    }

//    Cadastrar nova missao
    public MissaoDTO cadastrarMissao(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

//    Deletar missao por ID
    public void apagarMissao(Long id) {
        missaoRepository.deleteById(id);
    }

//    Atualizar missao por ID
    public MissaoDTO atualizarMissaoID(Long id, MissaoDTO missaoDTO) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        if (missao.isPresent()) {
            MissaoModel missaoModel = missaoMapper.map(missaoDTO);
            missaoModel.setId(id);
            MissaoModel updatedMissao = missaoRepository.save(missaoModel);
            return missaoMapper.map(updatedMissao);
        }
        return null;
    }
}
