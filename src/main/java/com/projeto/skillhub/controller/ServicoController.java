package com.projeto.skillhub.controller;

import com.projeto.skillhub.entity.Servico;
import com.projeto.skillhub.service.ServicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Serviços")
@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        return ResponseEntity.ok(servicoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id) {
        return ResponseEntity.ok(servicoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Servico> save(@RequestBody Servico servico) {
        return ResponseEntity.ok(servicoService.save(servico));
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicoService.delete(id);
    }

}
