package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypesOrBuilder;

import java.util.ArrayList;

public class LivrosDAO {
    private static ArrayList<Livros> listaLivros = new ArrayList<>();


    static {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Autores autor = new Autores("Stephen", "King", "J@", "123", "123", Genero.MASCULINO);
        Livros livro = new Livros("Stranger Things", 1, 200, autor, Status.AGUARDANDO_REVISAO);
        Autores autor2 = (Autores) pessoaDAO.selecionarCpf("12");
        Livros livro2 = new Livros("Stranger Things", 1, 200, autor2, Status.AGUARDANDO_EDICAO);
        Livros livro3 = new Livros("Harry Poter", 1, 200, autor2, Status.EM_REVISAO);
        Livros livro4 = new Livros("Ghostbuster", 1, 200, autor2, Status.APROVADO);

        listaLivros.add(livro);
        listaLivros.add(livro2);
        listaLivros.add(livro3);
        listaLivros.add(livro4);


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

    public ArrayList<Livros> selecionarAtividadesAutor(Pessoas autor){
        ArrayList<Livros> livrosAutor = new ArrayList<>();
        for(Livros livro : listaLivros){
            if(livro.getAutor().equals(autor) && livro.getStatus().equals(Status.AGUARDANDO_EDICAO)){
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

}