package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypesOrBuilder;

import java.util.ArrayList;

public class LivrosDAO {
    private static ArrayList<Livros> listaLivros = new ArrayList<>();


    static {
    Autores autor = new Autores("Stephen", "King", "J@", "123", "123", Genero.MASCULINO);
        Livros livro = new Livros("Stranger Things", 1, 200, autor, Status.AGUARDANDO_REVISAO);
        listaLivros.add(livro);
    }

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

    public ArrayList<Livros> buscarLista(){
        return listaLivros;
    }

    public ArrayList<Livros> selecionarPorAutor(Pessoas autor){
        ArrayList<Livros> livrosAutor = new ArrayList<>();
        for(Livros livro : listaLivros){
            if(livro.getAutor().equals(autor)){
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }
    public ArrayList<Livros> selecionarPorStatus(Status status){
        ArrayList<Livros> livrosAutor = new ArrayList<>();
        for(Livros livro : listaLivros){
            if(livro.getStatus().equals(status)){
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

}