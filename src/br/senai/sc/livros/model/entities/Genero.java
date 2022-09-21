package br.senai.sc.livros.model.entities;

public enum Genero {
    MASCULINO("Masculino"), FEMININO("Feminino"), OUTRO("Outro");
    String nome;

    Genero(String nome) {
        this.nome = nome;
    }

    public static Genero getGeneroCorreto(String generoString) {
        for(Genero genero : Genero.values()) {
            if(genero.nome.equals(generoString)) {
                return genero;
            }
        }
        throw new RuntimeException("Genero não encontrado!");
    }
}
