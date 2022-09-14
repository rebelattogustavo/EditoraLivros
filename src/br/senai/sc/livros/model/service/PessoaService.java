package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.PessoaDAO;
import br.senai.sc.livros.model.entities.Pessoas;

import java.sql.SQLException;

public class PessoaService {
    PessoaDAO dao = new PessoaDAO();

    public void inserir(Pessoas pessoa) throws SQLException {
        dao.inserir(pessoa);
    }

    public Pessoas selecionarEmail(String email) {
        return dao.selecionarEmail(email);
    }
}
