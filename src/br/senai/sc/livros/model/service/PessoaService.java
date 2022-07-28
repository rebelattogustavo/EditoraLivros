package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.PessoaDAO;
import br.senai.sc.livros.model.entities.Pessoas;

public class PessoaService {
    PessoaDAO dao = new PessoaDAO();

    public void inserir(Pessoas pessoa) {
        dao.inserir(pessoa);
    }

    public void remover(Pessoas pessoa) {
        dao.remover(pessoa);
    }

    public Pessoas selecionarCpf(String cpf) {
        return dao.selecionarCpf(cpf);
    }

    public Pessoas selecionarEmail(String email) {
        return dao.selecionarEmail(email);
    }

    public void atualizar(String cpf, Pessoas pessoaAtt) {
        dao.atualizar(cpf, pessoaAtt);
    }
}
