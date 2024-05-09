package br.com.fiap.minhaestante.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.minhaestante.model.Estante;
import br.com.fiap.minhaestante.model.Resenha;
import br.com.fiap.minhaestante.repository.ResenhaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("resenha")
@Slf4j
public class ResenhaController {

    @Autowired // Injeção de Dependência - Inversão de Controle
    ResenhaRepository repository;

    @GetMapping
    public List<Resenha> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Resenha create(@RequestBody @Valid Resenha resenha) {
        log.info("Cadastrando resenha {}", resenha);
        return repository.save(resenha);
    }

    @GetMapping("{id}")
    public ResponseEntity<Resenha> show(@PathVariable Long id) {
        log.info("buscando resenha com id {}", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping
    public Page<Estante> index(
        @RequestParam(required = false) String estante,
        @PageableDefault(sort = "data", direction = Direction.DESC) Pageable pageable){

        if(estante != null){
            return repository.findByEstanteTitulo(estante, pageable);
        }
        return repository.findAll(pageable);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando resenha {}", id);
        verificarSeCategoriaExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Resenha update(@PathVariable Long id, @RequestBody Resenha resenha) {
        log.info("atualizar resenha {} para {}", id, resenha);

        verificarSeCategoriaExiste(id);
        resenha.setId(id);
        return repository.save(resenha);
    }

    private void verificarSeCategoriaExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Não existe resenha com o id informado"));
    }

}
