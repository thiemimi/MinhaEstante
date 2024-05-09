package br.com.fiap.minhaestante.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.minhaestante.model.Estante;
import br.com.fiap.minhaestante.repository.EstanteRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {


    @Autowired
    EstanteRepository estanteRepository;

    @Override
    public void run(String... args) throws Exception {
        estanteRepository.saveAll(
            List.of(
                Estante.builder().id(1L).tituloLivro("Amanhecer").genero("romance").autor("tita").icone("book").build(),
                Estante.builder().id(2L).tituloLivro("Mo dao Zushi").genero("romance").autor("tita").icone("book").build()
            )
        );
    } 
    
}
