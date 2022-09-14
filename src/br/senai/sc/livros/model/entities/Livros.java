package br.senai.sc.livros.model.entities;

import br.senai.sc.livros.model.service.LivroService;

import java.util.Objects;

public class Livros {
    private Autores autor;
    private Editoras editora;
    private String titulo;
    private int isbn, qtdPag;
    private Status status;

    public Livros(String titulo, int isbn, int qtdPag, Autores autor, Status status) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.qtdPag = qtdPag;
        this.autor = autor;
        this.status = status;
    }

    public Livros() {

    }

    public Livros(int isbn, String titulo, int qtdPagina, String status, String editora, String pessoa_cpf) {
    }


    public static Livros cadastrar(String titulo, int isbn, int qtdPag, Autores autor) throws Exception {
        LivroService livroService = new LivroService();
        for (Livros livro : livroService.buscarLista()) {
            if (livro.getIsbn() == isbn) {
                throw new Exception("Isbn já cadastrado");
            } else {
                return new Livros(titulo, isbn, qtdPag, autor, Status.AGUARDANDO_REVISAO);
            }
        }
        return null;
    }

    public Autores getAutor() {
        return autor;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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


    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        Livros livros = (Livros) o;
        return this.isbn == livros.isbn;
    }

    @Override
    public int hashCode(){
        return isbn;
    }

}
