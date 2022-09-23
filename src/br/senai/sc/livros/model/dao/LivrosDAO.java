package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.Factory.ConexaoFactory;
import br.senai.sc.livros.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LivrosDAO {
    public boolean inserir(Livros livro) throws SQLException {
        Editoras editora = new Editoras("");
        String sql = "INSERT INTO livros(isbn, titulo, qtdPagina, status, editora, pessoa_cpf)" +
                " values (?,?,?,?,?,?)";


        ConexaoFactory conexao = new ConexaoFactory();
        conexao.connectionBD();
        Connection connection = conexao.connectionBD();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, livro.getIsbn());
            statement.setString(2, livro.getTitulo());
            statement.setInt(3, livro.getQtdPag());
            statement.setString(4, livro.getStatus().getNome());
            statement.setString(5, editora.getNome());
            statement.setString(6, livro.getAutor().getCpf());
            try {
                statement.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro ao inserir livro");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do SQL", e);
        }
        System.out.println("Processo finalizado com sucesso!");
        connection.close();
        return true;

    }

    public Livros selecionar(int isbn) throws SQLException {
        String sql = "SELECT * from livros WHERE isbn = ?";
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.connectionBD();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, isbn);
            ResultSet resultado = statement.executeQuery();
            Livros livro;
            if (resultado != null) {
                if (resultado.next()) {
                    livro = new Livros(
                            resultado.getInt("isbn"),
                            resultado.getString("titulo"),
                            resultado.getInt("qtdPagina"),
                            resultado.getString("status"),
                            resultado.getString("editora"),
                            resultado.getString("pessoa_cpf")
                    );
                    addAutor(livro);
                    return livro;
                }
//            contactsCollection.add(contact);
            } else {
                throw new RuntimeException("Deu ruim!");
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do SQL", e);
        }
        connection.close();
        System.out.println("Processo finalizado com sucesso!");
        return null;
    }

    public void atualizar(int isbn, Livros livroAtt) {
        String sql = "UPDATE livros SET titulo = ?, qtdPagina = ?, status = ?, editora = ?, pessoa_cpf = ? " +
                "WHERE isbn = ?";
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.connectionBD();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, livroAtt.getTitulo());
            statement.setInt(2, livroAtt.getQtdPag());
            statement.setString(3, livroAtt.getStatus().getNome());
            statement.setString(4, livroAtt.getEditora().getNome());
            statement.setString(5, livroAtt.getAutor().getCpf());
            statement.setInt(6, isbn);
            try {
                statement.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar livro");
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do SQL", e);
        }
    }

    public Collection<Livros> buscarLista() {
        Collection<Livros> livrosCollection = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.connectionBD();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultado = statement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Livros livro = new Livros(
                            resultado.getInt("isbn"),
                            resultado.getString("titulo"),
                            resultado.getInt("qtdPagina"),
                            resultado.getString("status"),
                            resultado.getString("editora"),
                            resultado.getString("pessoa_cpf")
                    );
                    addAutor(livro);
                    livrosCollection.add(livro);
                }
                return livrosCollection;
            } else {
                throw new RuntimeException("Deu ruim!");
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do SQL", e);
        }
    }


    public Collection<Livros> selecionarPorAutor(Pessoas autor)  {
        ArrayList<Livros> livrosAutor = new ArrayList<>();
        String sql = "SELECT * from livros WHERE pessoa_cpf = ?";
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.connectionBD();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, autor.getCpf());
            ResultSet resultado = statement.executeQuery();
            Livros livro;
            while (resultado != null && resultado.next()) {
                livro = new Livros(
                        resultado.getInt("isbn"),
                        resultado.getString("titulo"),
                        resultado.getInt("qtdPagina"),
                        resultado.getString("status"),
                        resultado.getString("editora"),
                        resultado.getString("pessoa_cpf")
                );
                if (livro.getPessoa_cpf().equals(autor.getCpf())) {
                    addAutor(livro);
                    livrosAutor.add(livro);
                }
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do SQL", e);
        }
        System.out.println("Processo finalizado com sucesso!");
        return livrosAutor;

    }

    public Collection<Livros> selecionarPorStatus(Status status) throws SQLException {
        Collection<Livros> livrosAutor = new ArrayList<>();
        String sql = "SELECT * from livros WHERE status = ?";
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.connectionBD();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, status.toString());
        ResultSet resultado = statement.executeQuery();
        Livros livro;
        while (resultado != null && resultado.next()) {
            livro = new Livros(
                    resultado.getInt("isbn"),
                    resultado.getString("titulo"),
                    resultado.getInt("qtdPagina"),
                    resultado.getString("status"),
                    resultado.getString("editora"),
                    resultado.getString("pessoa_cpf")
            );
            addAutor(livro);
            livrosAutor.add(livro);
        }
        connection.close();
        System.out.println("Processo finalizado com sucesso!");
        return livrosAutor;
    }

    public Collection<Livros> selecionarAtividadesAutor(Pessoas autor) throws SQLException {
        Collection<Livros> livrosAutor = new ArrayList<>();
        String sql = "SELECT * FROM livros where pessoa_cpf = ? and status = 'AGUARDANDO_EDICAO'";
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.connectionBD();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, autor.getCpf());
        ResultSet resultado = statement.executeQuery();
        Livros livro;
        while (resultado != null && resultado.next()) {
            livro = new Livros(
                    resultado.getInt("isbn"),
                    resultado.getString("titulo"),
                    resultado.getInt("qtdPagina"),
                    resultado.getString("status"),
                    resultado.getString("editora"),
                    resultado.getString("pessoa_cpf")
            );
            addAutor(livro);
            livrosAutor.add(livro);
        }
        connection.close();
        System.out.println("Processo finalizado com sucesso!");
        return livrosAutor;
    }

    public void addAutor(Livros livro) {
        PessoaDAO autor = new PessoaDAO();
        livro.setAutor((Autores) autor.selecionarCpf(livro.getPessoa_cpf()));
        livro.setEditora(new Editoras(""));
    }
}