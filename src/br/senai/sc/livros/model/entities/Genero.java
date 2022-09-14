package br.senai.sc.livros.model.entities;

public enum Genero {
    MASCULINO("Masculino"), FEMININO("Feminino"), OUTRO("Outro");
    String nome;

    Genero(String nome) {
        this.nome = nome;
    }
}
