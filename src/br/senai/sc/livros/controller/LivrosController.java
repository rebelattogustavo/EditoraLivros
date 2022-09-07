package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.*;
import br.senai.sc.livros.model.service.LivroService;
import br.senai.sc.livros.view.CadastroLivro;
import br.senai.sc.livros.view.Menu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class LivrosController {
    public boolean cadastrar(String titulo, int isbn, int qtdPag, Pessoas pessoa) throws Exception {
        Livros livro;
        livro = Livros.cadastrar(titulo, isbn, qtdPag, (Autores) pessoa);
        if (livro != null) {
            LivroService service = new LivroService();
            return service.inserir(livro);
        } else {
            CadastroLivro cadastroLivro = new CadastroLivro(pessoa, 1, null);
            cadastroLivro.setVisible(false);
            JOptionPane.showMessageDialog(null, "ISBN já existe!");
        }
        return true;
    }


    public Collection<Livros> buscarLista(int lista) {
        LivroService service = new LivroService();
        Pessoas usuario = Menu.userlogged();
        if (usuario instanceof Autores) {
            if (lista == 1) {
                return service.selecionarPorAutor(usuario);
            } else {
                return service.selecionarAtividadesAutor(usuario);
            }
        } else if (usuario instanceof Revisores) {
            if (lista == 1) {
                return service.selecionarPorStatus(Status.AGUARDANDO_REVISAO);
            } else {
                return service.selecionarPorStatus(Status.EM_REVISAO);
            }
        } else {
            if (lista == 1) {
                return service.buscarLista();
            } else {
                return service.selecionarPorStatus(Status.APROVADO);
            }
        }
    }

    public void editarLivro(String isbn, int opcao) {
        LivroService service = new LivroService();
        Livros livroAtualizado = service.selecionar(Integer.parseInt(isbn));
        if (Menu.userlogged() instanceof Autores) {
            livroAtualizado.setStatus(Status.AGUARDANDO_REVISAO);
        } else if (Menu.userlogged() instanceof Revisores) {
            if (opcao == 2) {
                livroAtualizado.setStatus(Status.AGUARDANDO_EDICAO);
            } else if (opcao == 3) {
                livroAtualizado.setStatus(Status.APROVADO);
            } else if (opcao == 4) {
                livroAtualizado.setStatus(Status.REPROVADO);
            } else {
                livroAtualizado.setStatus(Status.EM_REVISAO);
            }
        } else {
            if (opcao == 1) {
                livroAtualizado.setStatus(Status.AGUARDANDO_REVISAO);
            } else if (opcao == 4) {
                livroAtualizado.setStatus(Status.REPROVADO);
            } else if (opcao == 5) {
                Editoras editora = new Editoras("Gusta's");
                livroAtualizado.setStatus(Status.PUBLICADO);
                livroAtualizado.setEditora(editora);
            }
        }
        service.atualizar(Integer.parseInt(isbn), livroAtualizado);
    }

}