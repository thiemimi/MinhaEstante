package br.com.fiap.minhaestante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Resenha{

    @Id
    private Long id;
    private String tituloResenha;
    private String conteudoResenha;
    private int nota;
    private Data dataPostagem;
}

// criar um record no java vai definir uma estrutura de dados que tem seus atributos, seus métodos de 
// acessos e construtores
// record é IMUTÁVEL -> não pode ser gerenciado JPA
