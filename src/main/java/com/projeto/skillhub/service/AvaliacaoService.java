package com.projeto.skillhub.service;

import com.projeto.skillhub.entity.Avaliacao;
import com.projeto.skillhub.repository.AvaliacaoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Tag(name = "Avaliacoes")
@Service
@RequiredArgsConstructor
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> findAll(){
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findById(Long id){
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public Avaliacao save(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }

    public void delete(Long id){
        avaliacaoRepository.deleteById(id);
    }

}
