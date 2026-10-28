package com.projeto.skillhub.service;

import com.projeto.skillhub.entity.ServicoOferecido;
import com.projeto.skillhub.repository.ServicoOferecidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoOferecidoService {

    private final ServicoOferecidoRepository servicoOferecidoRepository;

    public List<ServicoOferecido> findAll() {
        return servicoOferecidoRepository.findAll();
    }

    public ServicoOferecido findById(Long id) {
        return servicoOferecidoRepository.findById(id).orElse(null);
    }


    public ServicoOferecido save(ServicoOferecido s) {
        return servicoOferecidoRepository.save(s);
    }


    public void delete(Long id) {
        servicoOferecidoRepository.deleteById(id);
    }


}
