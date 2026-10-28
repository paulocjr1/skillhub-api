package com.projeto.skillhub.controller;


import com.projeto.skillhub.entity.SolicitacaoServico;
import com.projeto.skillhub.service.SolicitacaoServicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Solicitação Serviço")
@RestController
@RequiredArgsConstructor
@RequestMapping("/solicitacoes-servico")
public class SolicitacaoServicoController {

    private final SolicitacaoServicoService solicitacaoServicoService;

    @GetMapping
    public ResponseEntity<List<SolicitacaoServico>> findAll() {
        return ResponseEntity.ok(solicitacaoServicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoServico> findById(@PathVariable Long id) {
        return ResponseEntity.ok(solicitacaoServicoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SolicitacaoServico>  save(@RequestBody SolicitacaoServico solicitacaoServico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoServicoService.save(solicitacaoServico));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        solicitacaoServicoService.deleteById(id);
    }

}
