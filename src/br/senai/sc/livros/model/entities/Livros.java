package br.senai.sc.livros.model.entities;

import br.senai.sc.livros.model.service.LivroService;

public class Livros {
    private Autores autor;
    private Editoras editora;
    private String titulo;
    private int isbn, qtdPag;
    private Status status;
    private String statusBD;
    private String pessoa_cpf;
    private String editoraBD;

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
        this.isbn = isbn;
        this.titulo = titulo;
        this.qtdPag = qtdPagina;
        this.statusBD = status;
        this.editoraBD = editora;
        this.pessoa_cpf = pessoa_cpf;
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

    public String getStatusBD() {
        return statusBD;
    }

    public String getPessoa_cpf() {
        return pessoa_cpf;
    }

    @Override
    public boolean equals(Object o) {
        Livros livros = (Livros) o;
        return this.isbn == livros.isbn;
    }

    @Override
    public int hashCode() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Livros{" +
                "autor=" + autor +
                ", editora=" + editora +
                ", titulo='" + titulo + '\'' +
                ", isbn=" + isbn +
                ", qtdPag=" + qtdPag +
                ", status=" + status +
                ", statusBD='" + statusBD + '\'' +
                ", pessoa_cpf='" + pessoa_cpf + '\'' +
                ", editoraBD='" + editoraBD + '\'' +
                '}';
    }
}
