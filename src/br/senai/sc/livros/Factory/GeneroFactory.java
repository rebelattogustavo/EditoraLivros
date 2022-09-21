package br.senai.sc.livros.Factory;

import br.senai.sc.livros.model.entities.Genero;

public class GeneroFactory {
    public Genero getGenero(String genero) {
        switch (genero) {
            case "Masculino":
                return Genero.MASCULINO;
            case "Feminino":
                return Genero.FEMININO;
            default:
                return Genero.OUTRO;
        }
    }
}
