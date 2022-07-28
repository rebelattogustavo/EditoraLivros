package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.Autores;
import br.senai.sc.livros.model.entities.Editoras;
import br.senai.sc.livros.model.entities.Livros;
import br.senai.sc.livros.model.entities.Pessoas;
import br.senai.sc.livros.model.service.LivroService;

public class LivrosController {

    Livros livro = new Livros();

    public Autores getAutor() {
        return livro.getAutor();
    }

    public void setAutor(Autores autor) {
        livro.setAutor(autor);
    }

    public Editoras getEditora() {
        return livro.getEditora();
    }

    public void setEditora(Editoras editora) {
        livro.setEditora(editora);
    }

    public String getTitulo() {
        return livro.getTitulo();
    }

    public void setTitulo(String titulo) {
        livro.setTitulo(titulo);
    }

    public int getStatus() {
        return livro.getStatus();
    }

    public void setStatus(int status) {
        livro.setStatus(status);
    }

    public int getIsbn() {
        return livro.getIsbn();
    }

    public void setIsbn(int isbn) {
        livro.setIsbn(isbn);
    }

    public int getQtdPag() {
        return livro.getQtdPag();
    }

    public void setQtdPag(int qtdPag) {
        livro.setQtdPag(qtdPag);
    }

    public void cadastrar(String titulo, int isbn, Pessoas pessoa, int qtdPag){
        Livros livro;
        livro = Livros.cadastrar(titulo, isbn, qtdPag, (Autores) pessoa);
        LivroService service = new LivroService();

    }

}