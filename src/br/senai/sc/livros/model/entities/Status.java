package br.senai.sc.livros.model.entities;

public enum Status {
    AGUARDANDO_REVISAO("AGUARDANDO_REVISAO"),
    EM_REVISAO("EM_REVISAO"),
    REPROVADO("REPROVADO"),
    AGUARDANDO_EDICAO("AGUARDANDO_EDICAO"),
    APROVADO("APROVADO"),
    PUBLICADO("PUBLICADO");

    String nome;

    Status(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
