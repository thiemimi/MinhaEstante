package br.com.fiap.minhaestante.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

        // for(Resenha resenha: repository){
        //     if (resenha.id().equals(id))
        //         return ResponseEntity.status(HttpStatus.OK).body(resenha);
        // }

        var resenhaEncontrada = getResenhaById(id);

        if(resenhaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(resenhaEncontrada.get());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("apagando resenha {}", id);

         var resenhaEncontrada = getResenhaById(id);

        if(resenhaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();


        repository = repository
                        .stream()
                        .filter(r -> !r.id().equals(id))
                        .toList();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Resenha> update(@PathVariable Long id, @RequestBody Resenha resenha){
        log.info("atualizar resenha {} para {}", id, resenha);

    // buscar a resenha antiga --> 404
    var resenhaEncontrada = getResenhaById(id);
    
    if(resenhaEncontrada.isEmpty())
        return ResponseEntity.notFound().build();

    var resenhaAntiga = resenhaEncontrada.get();

    // criar a resenha nova com os dados atualizados
    var resenhaNova = new Resenha(id, resenha.tituloResenha(), resenha.conteudoResenha(), resenha.nota(), resenha.dataPostagem())
    // apagar a resenha antiga 
    repository.remove(resenhaAntiga);
    // adicionar a resenha nova
    repository.add(resenhaNova);
        
    return ResponseEntity.ok(resenhaNova);

    }


    private Optional<Resenha> getResenhaById(Long id) {
        var resenhaEncontrada = repository
                                    .stream()
                                    .filter(r -> r.id().equals(id))
                                    .findFirst();
        return resenhaEncontrada;
    }
}
