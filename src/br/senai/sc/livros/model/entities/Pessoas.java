package br.senai.sc.livros.model.entities;

public class Pessoas {
    String nome, sobrenome, email, senha, cpf, genero;

    public Pessoas(String nome, String sobrenome, String email, String senha, String cpf, String genero) {
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
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean validalogin(String email, String senha){
        if(this.getSenha().equals(senha)){
            return true;
        }
        throw new RuntimeException();
    }

    public void cadastrar(String nome, String sobrenome, String email, String senha, String cpf, String genero){

    }

}
