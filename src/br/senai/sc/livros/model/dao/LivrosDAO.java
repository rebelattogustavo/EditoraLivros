package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.Factory.ConexaoFactory;
import br.senai.sc.livros.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LivrosDAO {
    private static Set<Livros> listaLivros = new HashSet<>();


    static {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Autores autor = new Autores("Stephen", "King", "J@", "123", "123", Genero.MASCULINO);
        Livros livro = new Livros("Robert Downey", 1, 200, autor, Status.AGUARDANDO_REVISAO);
        Autores autor2 = (Autores) pessoaDAO.selecionarCpf("12384567892");
        Livros livro2 = new Livros("Stranger Things", 2, 200, autor2, Status.AGUARDANDO_EDICAO);
        Livros livro3 = new Livros("Harry Poter", 3, 200, autor2, Status.EM_REVISAO);
        Livros livro4 = new Livros("Ghostbuster", 4, 200, autor2, Status.APROVADO);
        Editoras editora = new Editoras("");
        livro4.setEditora(editora);
        livro3.setEditora(editora);
        livro2.setEditora(editora);
        livro.setEditora(editora);

        listaLivros.add(livro);
        listaLivros.add(livro2);
        listaLivros.add(livro3);
        listaLivros.add(livro4);


    }

    public boolean inserir(Livros livro) throws SQLException {
        if (listaLivros.contains(livro)) {
            return false;
        }
        Editoras editora = new Editoras("");
        String sql = "INSERT INTO livros(isbn, titulo, qtdPagina, status, editora, pessoa_cpf)" +
                " values (?,?,?,?,?,?)";

        System.out.println(livro.getStatus().toString());

        ConexaoFactory conexao = new ConexaoFactory();
        conexao.connectionBD();
        Connection connection = conexao.connectionBD();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, livro.getIsbn());
        statement.setString(2, livro.getTitulo());
        statement.setInt(3, livro.getQtdPag());
        statement.setString(4, livro.getStatus().toString());
        statement.setString(5, "");
        statement.setString(6, livro.getAutor().getCpf());

        statement.execute();
        System.out.println("Processo finalizado com sucesso!");
        connection.close();
        listaLivros.add(livro);
        return true;

    }

    public void remover(Livros livro) {
        listaLivros.remove(livro);
    }

    public Livros selecionar(int isbn) throws SQLException {
        String sql = "SELECT * from contatos WHERE isbn = ?";
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.connectionBD();
        PreparedStatement statement = connection.prepareStatement(sql);
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
                return livro;
            }
//            contactsCollection.add(contact);
        } else {
            throw new RuntimeException("Deu ruim!");
        }
        connection.close();
        System.out.println("Processo finalizado com sucesso!");
        return null;
//        for (Livros livro : listaLivros) {
//            if (livro.getIsbn() == isbn) {
//                return livro;
//            }
//        }
//        throw new RuntimeException();
    }

    public void atualizar(int isbn, Livros livroAtt) {
        for (Livros livro : listaLivros) {
            if (livro.getIsbn() == isbn) {
                listaLivros.remove(livro);
                listaLivros.add(livroAtt);
            }
        }
    }

    public Collection<Livros> buscarLista() {
        return Collections.unmodifiableCollection(listaLivros);
    }


    public Collection<Livros> selecionarPorAutor(Pessoas autor) throws SQLException {
        System.out.println(autor.getNome());
        ArrayList<Livros> livrosAutor = new ArrayList<>();
        String sql = "SELECT * from livros WHERE pessoa_cpf = ?";
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.connectionBD();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, autor.getCpf());
        ResultSet resultado = statement.executeQuery();
        int verifica;
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
                livrosAutor.add(livro);
            }
        }
        System.out.println("Processo finalizado com sucesso!");
        System.out.println(livrosAutor);
        connection.close();
        return livrosAutor;


//        for (Livros livro : listaLivros) {
//            if (livro.getAutor().equals(autor)) {
//                livrosAutor.add(livro);
//            }
//        }
//        System.out.println(livrosAutor);
//        return livrosAutor;
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
        while (resultado != null) {
            if (resultado.next()) {
                livro = new Livros(
                        resultado.getInt("isbn"),
                        resultado.getString("titulo"),
                        resultado.getInt("qtdPagina"),
                        resultado.getString("status"),
                        resultado.getString("editora"),
                        resultado.getString("pessoa_cpf")
                );
                livrosAutor.add(livro);
            } else {
                throw new RuntimeException("Deu ruim!");
            }
        }
        connection.close();
        System.out.println("Processo finalizado com sucesso!");
        return livrosAutor;
//        for (Livros livro : listaLivros) {
//            if (livro.getStatus().equals(status)) {
//                livrosAutor.add(livro);
//            }
//        }
//        return livrosAutor;
    }

    public Collection<Livros> selecionarAtividadesAutor(Pessoas autor) throws SQLException {
        Collection<Livros> livrosAutor = new ArrayList<>();
        String sql = "SELECT * FROM livros where pessoa_cpf = ? and status = 'Aguardando edição'";
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.connectionBD();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, autor.getCpf());
        ResultSet resultado = statement.executeQuery();
        Livros livro;
        while (resultado != null) {
            if (resultado.next()) {
                livro = new Livros(
                        resultado.getInt("isbn"),
                        resultado.getString("titulo"),
                        resultado.getInt("qtdPagina"),
                        resultado.getString("status"),
                        resultado.getString("editora"),
                        resultado.getString("pessoa_cpf")
                );

                livrosAutor.add(livro);
            } else {
                throw new RuntimeException("Deu ruim!");
            }
        }
        connection.close();
        System.out.println("Processo finalizado com sucesso!");
        return livrosAutor;
//        for (Livros livro : listaLivros) {
//            if (livro.getAutor().equals(autor) && livro.getStatus().equals(Status.AGUARDANDO_EDICAO)) {
//                livrosAutor.add(livro);
//            }
//        }
//        return livrosAutor;
    }

}