package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.LivrosDAO;
import br.senai.sc.livros.model.entities.Livros;

public class LivroService {
    LivrosDAO acesso = new LivrosDAO();

    public void inserir(Livros livro) {
        acesso.inserir(livro);
    }

    public void remover(Livros livro) {
        acesso.remover(livro);
    }

    public Livros selecionar(int isbn) {
        return acesso.selecionar(isbn);
    }

    public void atualizar(int isbn, Livros livroAtt) {
        acesso.atualizar(isbn, livroAtt);
    }
}
