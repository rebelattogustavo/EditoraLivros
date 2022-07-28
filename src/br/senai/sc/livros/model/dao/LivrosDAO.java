package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.Livros;

import java.util.ArrayList;

public class LivrosDAO {
    private ArrayList<Livros> listaLivros = new ArrayList<>();

    public void inserir(Livros livro){
        listaLivros.add(livro);
    }

    public void remover(Livros livro){
        listaLivros.remove(livro);
    }

    public Livros selecionar(int isbn){
        for (Livros livro : listaLivros){
            if(livro.getIsbn() == isbn){
                return livro;
            }
        }
        throw new RuntimeException();
    }

    public void atualizar(int isbn, Livros livroAtt){
        for(int i =0; i< listaLivros.size(); i++){
            if(listaLivros.get(i).getIsbn() == isbn){
                listaLivros.set(i, livroAtt);
            }
        }
    }

}