package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.Autores;
import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Pessoas;
import br.senai.sc.livros.model.service.PessoaService;

public class PessoaController {

    Pessoas pessoa;

    public boolean validalogin(String email, String senha) {
        PessoaService service = new PessoaService();
        pessoa = service.selecionarEmail(email);
        return pessoa.validalogin(email, senha);
    }

    public void cadastrar(String nome, String sobrenome, String email, String senha, String cpf, Object genero){
        PessoaService service = new PessoaService();
        service.inserir(Pessoas.cadastrar(nome, sobrenome, email, senha, cpf, (Genero) genero));
    }
}