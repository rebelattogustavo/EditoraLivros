package br.senai.sc.livros.model.entities;

import br.senai.sc.livros.Factory.PessoaFactory;
import br.senai.sc.livros.view.Menu;

import java.util.Objects;

public class Pessoas {
    private String nome, sobrenome, email, senha, cpf;
    private Genero genero;

    public Pessoas(String nome, String sobrenome, String email, String senha, String cpf, Genero genero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getGenero() {
        return genero.nome;
    }

    public void setGenero(String genero) {
        this.genero = Genero.valueOf(genero);
    }

    public Pessoas validaLogin(String senha) {
        if (this.getSenha().equals(senha)) {
            return this;
        }
        throw new RuntimeException("Senha incorreta");
    }

    public static Pessoas cadastrar(String nome, String sobrenome, String email,
                                    String senha, String cpf, Genero genero, String confSenha) {
        if (senha.equals(confSenha)) {
            if (email.contains("@")) {
                int tipo = 1;
                if (Menu.userlogged() instanceof Diretores) {
                    tipo = 2;
                }
                return new PessoaFactory().getPessoa(nome, sobrenome, email, senha, cpf, genero.nome, tipo);
            }
            throw new RuntimeException("E-mail incorreto");
        }
        throw new RuntimeException("Senhas não conferem");
    }

    @Override
    public boolean equals(Object o) {
        Pessoas outraPessoa = (Pessoas) o;
        return cpf.equals(outraPessoa.cpf);
    }

    @Override
    public int hashCode() {
        return cpf.charAt(0);
    }
}
