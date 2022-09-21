package br.senai.sc.livros.model.entities;

public enum Status {
    AGUARDANDO_REVISAO("Aguardando revisão"),
    EM_REVISAO("Em revisão"),
    REPROVADO("Reprovado"),
    AGUARDANDO_EDICAO("Aguardando edição"),
    APROVADO("Aprovado"),
    PUBLICADO("Publicado");

    String nome;

    Status(String nome) {
        this.nome = nome;
    }

    public static Status getStatusCorreto(String statusString) {
        for(Status status : Status.values()) {
            if(status.nome.equals(statusString)) {
                return status;
            }
        }
        throw new RuntimeException("Status não encontrado!");
    }

}
