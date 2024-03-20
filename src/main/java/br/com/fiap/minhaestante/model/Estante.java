package br.com.fiap.minhaestante.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Estante {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @NotBlank(message = "O título é obrigatório")
    private String tituloLivro;

    private String genero;

    private String autor;

    private LocalDate dataInicio;
}
