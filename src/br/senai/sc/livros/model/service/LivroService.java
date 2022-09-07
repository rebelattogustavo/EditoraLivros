package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.LivrosDAO;
import br.senai.sc.livros.model.entities.Livros;
import br.senai.sc.livros.model.entities.Pessoas;
import br.senai.sc.livros.model.entities.Status;

import java.util.ArrayList;
import java.util.Collection;

public class LivroService {
    LivrosDAO acesso = new LivrosDAO();

    public boolean inserir(Livros livro) {
        return acesso.inserir(livro);
    }

    public Livros selecionar(int isbn) {
        return acesso.selecionar(isbn);
    }

    public void atualizar(int isbn, Livros livroAtt) {
        acesso.atualizar(isbn, livroAtt);
    }

    public Collection<Livros> buscarLista() {
        return acesso.buscarLista();
    }

    public Collection<Livros> selecionarPorAutor(Pessoas autor) {
        return acesso.selecionarPorAutor(autor);
    }

    public Collection<Livros> selecionarPorStatus(Status status) {
        return acesso.selecionarPorStatus(status);
    }

    public Collection<Livros> selecionarAtividadesAutor(Pessoas autor) {
        return acesso.selecionarAtividadesAutor(autor);
    }
}
