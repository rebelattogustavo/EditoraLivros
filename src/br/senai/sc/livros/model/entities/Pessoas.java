package br.senai.sc.livros.model.entities;

import br.senai.sc.livros.model.service.PessoaService;

public class Pessoas {
    String nome, sobrenome, email, senha, cpf;
    Genero genero;

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

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
                return new Pessoas(nome, sobrenome, email, senha, cpf, genero);
            }
            throw new RuntimeException("E-mail incorreto");
        }
        throw new RuntimeException("Senhas não conferem");
    }

}
