package br.com.fiap.minhaestante.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class Resenha{

    @Id
    private Long id;
    @@NotBlank(message = "{resenha.tituloResenha.notblank}")
    private String tituloResenha;
    @NotNull
    private String conteudoResenha;
    @Positive
    private int nota;
    private LocalDate dataPostagem;
}

// criar um record no java vai definir uma estrutura de dados que tem seus atributos, seus métodos de 
// acessos e construtores
// record é IMUTÁVEL -> não pode ser gerenciado JPA
