package br.com.fiap.minhaestante.controller;


import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.minhaestante.model.Estante;
import br.com.fiap.minhaestante.repository.EstanteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("estante")
public class EstanteController {
    
    @Autowired //injeçaõ de dependencia
    EstanteRepository repository;

    @GetMapping
    public List<Estante> index(){
        return repository.findAll();

    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Estante create(@RequestBody @Valid Estante estante){
        return repository.save(estante);
    }
}
