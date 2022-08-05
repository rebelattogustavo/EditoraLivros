package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.*;
import br.senai.sc.livros.model.service.LivroService;
import br.senai.sc.livros.view.CadastroLivro;
import br.senai.sc.livros.view.Menu;

import javax.swing.*;
import java.util.ArrayList;

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

    public Status getStatus() {
        return livro.getStatus();
    }

    public void setStatus(Status status) {
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

    public void cadastrar(String titulo, int isbn, int qtdPag,Pessoas pessoa) throws Exception {
        Livros livro;
        livro = Livros.cadastrar(titulo, isbn, qtdPag, (Autores) pessoa);
        if(livro != null){
            LivroService service = new LivroService();
            service.inserir(livro);
        }else{
            CadastroLivro cadastroLivro = new CadastroLivro(pessoa);
            cadastroLivro.setVisible(false);
            JOptionPane.showMessageDialog(null, "ISBN já existe!");
        }
    }


    public ArrayList<Livros> buscarLista(int lista){
        LivroService service = new LivroService();
        Pessoas usuario = Menu.userlogged();
        if (usuario instanceof Autores){
            if (lista == 1){
                return service.selecionarPorAutor(usuario);
            } else{
                return service.selecionarAtividadesAutor(usuario);
            }
        } else if(usuario instanceof Revisores) {
            if (lista == 1){
                return service.selecionarPorStatus(Status.AGUARDANDO_REVISAO);
            } else{
                return service.selecionarPorStatus(Status.EM_REVISAO);
            }
        }else {
            if (lista == 1){
                return service.buscarLista();
            } else{
                return service.selecionarPorStatus(Status.APROVADO);
            }
        }
    }

    public void editarLivro(String isbn) {
        LivroService service = new LivroService();
        Livros livroAtualizado = service.selecionar(Integer.parseInt(isbn));
        if (Menu.userlogged() instanceof Autores) {
            livroAtualizado.setStatus(Status.AGUARDANDO_REVISAO);
        }
        service.atualizar(Integer.parseInt(isbn), livroAtualizado);
    }



//    public ArrayList<Livros> selecionarPorAutor(Autores autor){
//        LivroService service = new LivroService();
//        return service.selecionarPorAutor(autor);
//    }

}