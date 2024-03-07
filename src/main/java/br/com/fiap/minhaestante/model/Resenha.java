package br.com.fiap.minhaestante.model;

import java.util.Random;

import javax.xml.crypto.Data;

public record Resenha(Long id, String tituloResenha, String conteudoResenha, int nota, Data dataPostagem) {
    public Resenha(Long id, String tituloResenha, String conteudoResenha, int nota, Data dataPostagem){
        this.id = (id == null)? Math.abs(new Random().nextLong()): id;
        this.tituloResenha = tituloResenha;
        this.conteudoResenha = conteudoResenha;
        this.nota = nota;
        this.dataPostagem = dataPostagem;
    }

}

// criar um record no java vai definir uma estrutura de dados que tem seus atributos, seus métodos de 
// acessos e construtores
// record é IMUTÁVEL 
