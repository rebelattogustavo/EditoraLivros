package br.senai.sc.livros.Factory;

import br.senai.sc.livros.model.dao.PessoaDAO;
import br.senai.sc.livros.model.entities.*;

public class PessoaFactory {
    public static Pessoas getPessoa(String nome, String sobrenome, String email, String senha, String cpf,
                                    String genero, Integer tipo) {
        switch (tipo) {
            case 1:
                return new Autores(nome, sobrenome, email, senha, cpf, new GeneroFactory().getGenero(genero));
            case 2:
                return new Revisores(nome, sobrenome, email, senha, cpf, new GeneroFactory().getGenero(genero));
            case 3:
                return new Diretores(nome, sobrenome, email, senha, cpf, new GeneroFactory().getGenero(genero));
            default:
                return null;
        }
    }
}
