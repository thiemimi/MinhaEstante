package br.com.fiap.minhaestante.model;

import java.util.Random;

public record Resenha(Long id, String nome, String icone) {
    public Resenha(Long id, String nome, String icone){
        this.id = Math.abs(new Random().nextLong());
        this.nome = nome;
        this.icone = icone;
    }

}

// criar um record no java vai definir uma estrutura de dados que tem seus atributos, seus métodos de 
// acessos e construtores
// record é IMUTÁVEL 
