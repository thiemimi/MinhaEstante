package br.com.fiap.minhaestante.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.minhaestante.model.Resenha;


@RestController
@RequestMapping("/resenha")
public class ResenhaController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    List<Resenha> repository = new ArrayList<>();

    //localhost
    @GetMapping
    public List<Resenha> index(){
        return repository;
    }

    @PostMapping
    public ResponseEntity<Resenha> create(@RequestBody Resenha resenha){ //binding
        log.info("cadastrando resenha {}", resenha);
        repository.add(resenha);
        return ResponseEntity.status(HttpStatus.CREATED).body(resenha);
    }

    @GetMapping("{id}")
    public ResponseEntity<Resenha> show(@PathVariable Long id){
        log.info("buscando resenha com id{}", id);

        for(Resenha resenha: repository){
            if (resenha.id().equals(id))
                return ResponseEntity.status(HttpStatus.OK).body(resenha);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
