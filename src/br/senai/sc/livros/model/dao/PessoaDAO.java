package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;
import br.senai.sc.livros.model.service.PessoaService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PessoaDAO {
    private static Set<Pessoas> listaPessoas = new HashSet<>();


    static {
        Pessoas guga = new Pessoas("Guga", "Guga", "1@", "123", "123456789", Genero.MASCULINO);
        Autores asa = new Autores("Asa", "Asa", "2@", "123", "10614164966", Genero.MASCULINO);
        Revisores jose = new Revisores("Jose", "Jose", "3@", "123", "23", Genero.MASCULINO);
        Diretores maria = new Diretores("Maria", "Maria", "4@", "123", "34", Genero.FEMININO);

        listaPessoas.add(guga);
        listaPessoas.add(asa);
        listaPessoas.add(jose);
        listaPessoas.add(maria);
    }

    public static void inserir(Pessoas pessoa) throws SQLException {
        System.out.println(pessoa.getGenero());
        String sql = "INSERT INTO pessoas(cpf, nome, sobrenome, email, senha, genero)" +
                " values (?,?,?,?,?,?)";

        Conexao conexao = new Conexao();
        conexao.connectionBD();
        Connection connection = conexao.connectionBD();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pessoa.getCpf());
        statement.setString(2, pessoa.getNome());
        statement.setString(3, pessoa.getSobrenome());
        statement.setString(4, pessoa.getEmail());
        statement.setString(5, pessoa.getSenha());
        statement.setString(6, pessoa.getGenero());

        statement.execute();
        System.out.println("Processo finalizado com sucesso!");
        connection.close();
        listaPessoas.add(pessoa);
    }

    public void remover(Pessoas pessoa) {
        listaPessoas.remove(pessoa);
    }


    public Pessoas selecionarCpf(String cpf) {
        for (Pessoas pessoa : listaPessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        throw new RuntimeException("Pessoa não encontrada");
    }

    public Pessoas selecionarEmail(String email) {
        for (Pessoas pessoa : listaPessoas) {
            if (pessoa.getEmail().equals(email)) {
                return pessoa;
            }
        }
        throw new RuntimeException("Email não encontrado");
    }

    public void atualizar(String cpf, Pessoas pessoaAtt) {
        for (Pessoas pessoa : listaPessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                listaPessoas.remove(pessoa);
                listaPessoas.add(pessoa);
            }
        }
    }


}
