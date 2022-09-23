package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Pessoas;
import br.senai.sc.livros.model.service.PessoaService;

public class PessoaController {

    Pessoas model;

    public Pessoas validaLogin(String email, String senha) {
        PessoaService service = new PessoaService();
        model = service.selecionarEmail(email);
        return model.validaLogin(senha);
    }

    public void cadastrar(String nome, String sobrenome, String email, String senha,
                          String cpf, Object genero, String confSenha)  {

        PessoaService service = new PessoaService();
        Pessoas pessoa = Pessoas.cadastrar(nome, sobrenome, email, senha, cpf, (Genero) genero, confSenha);
        service.inserir(pessoa);
    }
}