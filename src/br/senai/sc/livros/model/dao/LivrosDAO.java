package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypesOrBuilder;

import java.util.*;

public class LivrosDAO {
    private static Set<Livros> listaLivros = new HashSet<>();


    static {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Autores autor = new Autores("Stephen", "King", "J@", "123", "123", Genero.MASCULINO);
        Livros livro = new Livros("Robert Downey", 1, 200, autor, Status.AGUARDANDO_REVISAO);
        Autores autor2 = (Autores) pessoaDAO.selecionarCpf("12");
        Livros livro2 = new Livros("Stranger Things", 2, 200, autor2, Status.AGUARDANDO_EDICAO);
        Livros livro3 = new Livros("Harry Poter", 3, 200, autor2, Status.EM_REVISAO);
        Livros livro4 = new Livros("Ghostbuster", 4, 200, autor2, Status.APROVADO);
        Editoras editora = new Editoras("");
        livro4.setEditora(editora);
        livro3.setEditora(editora);
        livro2.setEditora(editora);
        livro.setEditora(editora);

        listaLivros.add(livro);
        listaLivros.add(livro2);
        listaLivros.add(livro3);
        listaLivros.add(livro4);


    }

    public boolean inserir(Livros livro) {
        if (listaLivros.contains(livro)) {
            return false;
        }
        Editoras editora = new Editoras("");
        livro.setEditora(editora);
        listaLivros.add(livro);
        return true;

    }

    public void remover(Livros livro) {
        listaLivros.remove(livro);
    }

    public Livros selecionar(int isbn) {
        for (Livros livro : listaLivros) {
            if (livro.getIsbn() == isbn) {
                return livro;
            }
        }
        throw new RuntimeException();
    }

    public void atualizar(int isbn, Livros livroAtt) {
        for (Livros livro : listaLivros) {
            if (livro.getIsbn() == isbn) {
                listaLivros.remove(livro);
                listaLivros.add(livroAtt);
            }
        }
    }

    public Collection<Livros> buscarLista() {
        return Collections.unmodifiableCollection(listaLivros);
    }


    public Collection<Livros> selecionarPorAutor(Pessoas autor) {
        System.out.println(autor.getNome());
        ArrayList<Livros> livrosAutor = new ArrayList<>();
        for (Livros livro : listaLivros) {
            if (livro.getAutor().equals(autor)) {
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

    public Collection<Livros> selecionarPorStatus(Status status) {
        Collection<Livros> livrosAutor = new ArrayList<>();
        for (Livros livro : listaLivros) {
            if (livro.getStatus().equals(status)) {
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

    public Collection<Livros> selecionarAtividadesAutor(Pessoas autor) {
        Collection<Livros> livrosAutor = new ArrayList<>();
        for (Livros livro : listaLivros) {
            if (livro.getAutor().equals(autor) && livro.getStatus().equals(Status.AGUARDANDO_EDICAO)) {
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

}