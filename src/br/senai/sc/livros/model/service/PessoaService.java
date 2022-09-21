package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.PessoaDAO;
import br.senai.sc.livros.model.entities.Pessoas;

import java.sql.SQLException;

public class PessoaService {

    public void inserir(Pessoas pessoa) throws SQLException {
        new PessoaDAO().inserir(pessoa);
    }

    public Pessoas selecionarEmail(String email) {
        return new PessoaDAO().selecionarEmail(email);
    }

    public Pessoas selecionarCpf(String cpf) {
        return new PessoaDAO().selecionarCpf(cpf);
    }

}
