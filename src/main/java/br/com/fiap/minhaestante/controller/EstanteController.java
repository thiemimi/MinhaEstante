package br.com.fiap.minhaestante.controller;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("{id}")
    public ResponseEntity<Estante> show(@PathVariable Long id) {
        return repository
                        .findById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        verificarSeLivroExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Estante update(@PathVariable Long id, @RequestBody Estante estante){
        verificarSeLivroExiste(id);
        estante.setId(id);
        return repository.save(estante);
    }

    private void verificarSeLivroExiste(Long id){
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                "Não existe livo com o id informado"));
    }
}
