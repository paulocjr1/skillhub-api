package com.projeto.skillhub.controller;

import com.projeto.skillhub.entity.ServicoOferecido;
import com.projeto.skillhub.service.ServicoOferecidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Serviços Oferecidos")
@RestController
@RequiredArgsConstructor
@RequestMapping("/servicos-oferecidos")
public class ServicoOferecidoController {

    private final ServicoOferecidoService servicoOferecidoService;


    @GetMapping
    public ResponseEntity<List<ServicoOferecido>> findAll() {
        return ResponseEntity.ok(servicoOferecidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoOferecido> findById(@PathVariable Long id) {
        return ResponseEntity.ok(servicoOferecidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ServicoOferecido> save(@RequestBody ServicoOferecido s) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoOferecidoService.save(s));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicoOferecidoService.delete(id);
    }
}
