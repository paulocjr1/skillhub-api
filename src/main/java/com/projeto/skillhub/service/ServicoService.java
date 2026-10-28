package com.projeto.skillhub.service;

import com.projeto.skillhub.entity.Servico;
import com.projeto.skillhub.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public  ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Servico> findAll(){
        return servicoRepository.findAll();
    }

    public Servico findById(Long id) {
        return servicoRepository.findById(id).orElse(null);
    }
    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }
    public void delete(Long id) {
        servicoRepository.deleteById(id);
    }

}