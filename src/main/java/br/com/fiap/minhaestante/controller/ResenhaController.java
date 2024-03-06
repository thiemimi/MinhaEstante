package br.com.fiap.minhaestante.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fiap.minhaestante.model.Resenha;


@Controller
public class ResenhaController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    List<Resenha> repository = new ArrayList<>();

    //localhost
    @RequestMapping(
        method = RequestMethod.GET, 
        path= "/resenha", 
        produces ="application/json")
    @ResponseBody
    public List<Resenha> index(){
        return repository;
    }

    @RequestMapping(
        method = RequestMethod.POST,
        path = "/resenha",
        produces = "application/json",
        consumes = "application/json"
    )
    @ResponseBody
    public void create(@RequestBody String resenha){ //binding
        log.info("cadastrando categoria {}", resenha);
        repository.add(new Resenha(1L, "Resenha", "Nome do Livro"));
    }


}
