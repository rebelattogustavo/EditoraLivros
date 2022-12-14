package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.PessoaDAO;
import br.senai.sc.livros.model.entities.Pessoas;

public class PessoaService {

    public void inserir(Pessoas pessoa) {
        new PessoaDAO().inserir(pessoa);
    }

    public Pessoas selecionarEmail(String email) {
        return new PessoaDAO().selecionarEmail(email);
    }

}
