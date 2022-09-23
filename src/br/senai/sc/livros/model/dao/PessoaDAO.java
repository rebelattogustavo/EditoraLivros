package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.Factory.ConexaoFactory;
import br.senai.sc.livros.Factory.PessoaFactory;
import br.senai.sc.livros.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PessoaDAO {
    private static Set<Pessoas> listaPessoas = new HashSet<>();
    private Connection conexao;


    public PessoaDAO() {
        this.conexao = new ConexaoFactory().connectionBD();
    }

    public void inserir(Pessoas pessoa) {
        String sql = "INSERT INTO pessoas(cpf, nome, sobrenome, email, senha, genero, tipo)" +
                " values (?,?,?,?,?,?,?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, pessoa.getCpf());
            statement.setString(2, pessoa.getNome());
            statement.setString(3, pessoa.getSobrenome());
            statement.setString(4, pessoa.getEmail());
            statement.setString(5, pessoa.getSenha());
            statement.setString(6, pessoa.getGenero());
            statement.setInt(7,
                    (pessoa instanceof Autores) ? 1 :
                            (pessoa instanceof Revisores) ? 2 :
                                    (pessoa instanceof Diretores) ? 3 : 0);

            try {
                statement.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro ao inserir pessoa");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do SQL", e);
        }
        System.out.println("Processo finalizado com sucesso!");
    }

    public Pessoas selecionarCpf(String cpf) {
        String sql = "SELECT * FROM pessoas WHERE cpf = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, cpf);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extrairObjeto(resultSet);
                }
                statement.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro ao selecionar cpf");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do SQL2", e);
        }
        throw new RuntimeException("Algo deu ruim");
    }

    public Pessoas selecionarEmail(String email) {
        String sql = "SELECT * FROM pessoas WHERE email = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {

                    return extrairObjeto(resultSet);
                }
                statement.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro ao selecionar email");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do SQL2", e);
        }
        throw new RuntimeException("Algo deu ruim");
    }

    private Pessoas extrairObjeto(ResultSet resultSet) throws SQLException {
        try {
            return new PessoaFactory().getPessoa(
                    resultSet.getString("nome"),
                    resultSet.getString("sobrenome"),
                    resultSet.getString("email"),
                    resultSet.getString("senha"),
                    resultSet.getString("cpf"),
                    resultSet.getString("genero"),
                    resultSet.getInt("tipo")
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair objeto");
        }
    }
}
