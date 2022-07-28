package br.senai.sc.livros.model.entities;

public class Livros {
    private Autores autor;
    private Editoras editora;
    private String titulo;
    private int isbn, qtdPag;
    private Status status;

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public Editoras getEditora() {
        return editora;
    }

    public void setEditora(Editoras editora) {
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getStatus() {
        return status.ordinal();
    }


    public void setStatus(int status) {
        this.status = Status.values()[status];
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getQtdPag() {
        return qtdPag;
    }

    public void setQtdPag(int qtdPag) {
        this.qtdPag = qtdPag;
    }
}
