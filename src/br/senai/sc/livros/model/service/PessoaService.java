package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.PessoaDAO;
import br.senai.sc.livros.model.entities.Pessoas;

public class PessoaService {
    PessoaDAO dao = new PessoaDAO();

    public void inserir(Pessoas pessoa) {
        dao.inserir(pessoa);
    }

    public Pessoas selecionarEmail(String email) {
        return dao.selecionarEmail(email);
    }
}
