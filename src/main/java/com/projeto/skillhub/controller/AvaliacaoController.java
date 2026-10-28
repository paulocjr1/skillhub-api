package com.projeto.skillhub.controller;


import com.projeto.skillhub.entity.Avaliacao;
import com.projeto.skillhub.service.AvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;


    @GetMapping
    public ResponseEntity<List<Avaliacao>>FindAll(){
        return ResponseEntity.ok(avaliacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable Long id){
        return ResponseEntity.ok(avaliacaoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Avaliacao> save(@RequestBody Avaliacao avaliacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.save(avaliacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteById(@PathVariable Long id){
        avaliacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
