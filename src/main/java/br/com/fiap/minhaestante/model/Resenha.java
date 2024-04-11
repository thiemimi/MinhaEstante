package br.com.fiap.minhaestante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Resenha{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "{resenha.tituloResenha.notblank}")  
    private String tituloResenha;
    private String conteudoResenha;
    private String icone;
    private int nota;
}

