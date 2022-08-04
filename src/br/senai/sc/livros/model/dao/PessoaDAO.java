package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Livros;
import br.senai.sc.livros.model.entities.Pessoas;
import br.senai.sc.livros.model.service.PessoaService;

import java.util.ArrayList;

public class PessoaDAO {
    private static ArrayList<Pessoas> listaPessoas = new ArrayList<>();


    static {
        Pessoas guga = new Pessoas("Guga", "Guga", "1@", "123", "123456789", Genero.MASCULINO);
        listaPessoas.add(guga);
    }

    public static void inserir(Pessoas pessoa){
        listaPessoas.add(pessoa);
    }

    public void remover(Pessoas pessoa){
        listaPessoas.remove(pessoa);
    }



    public Pessoas selecionarCpf(String cpf){
        for (Pessoas pessoa : listaPessoas){
            if(pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        throw new RuntimeException("Pessoa não encontrada");
    }
    public Pessoas selecionarEmail(String email){
        for (Pessoas pessoa : listaPessoas){
            if(pessoa.getEmail().equals(email)){
                return pessoa;
            }
        }
        throw new RuntimeException("Email não encontrado");
    }

    public void atualizar(String cpf, Pessoas pessoaAtt){
        for(int i =0; i< listaPessoas.size(); i++){
            if(listaPessoas.get(i).getCpf().equals(cpf)){
                listaPessoas.set(i, pessoaAtt);
            }
        }
    }
    
}
