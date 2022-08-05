package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.LivrosDAO;
import br.senai.sc.livros.model.entities.Livros;
import br.senai.sc.livros.model.entities.Pessoas;
import br.senai.sc.livros.model.entities.Status;

import java.util.ArrayList;

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

    public ArrayList<Livros> buscarLista(){
        return acesso.buscarLista();
    }

    public ArrayList<Livros> selecionarPorAutor(Pessoas autor) {
        return acesso.selecionarPorAutor(autor);
    }

    public ArrayList<Livros> selecionarPorStatus(Status status) {
        return acesso.selecionarPorStatus(status);
    }

    public ArrayList<Livros> selecionarAtividadesAutor(Pessoas autor) {
        return acesso.selecionarAtividadesAutor(autor);
    }



}
