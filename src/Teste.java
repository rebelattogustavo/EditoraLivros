import br.senai.sc.livros.model.dao.LivrosDAO;
import br.senai.sc.livros.model.entities.Livros;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Teste {
    public static void main(String[] args) {
        LivrosDAO dao = new LivrosDAO();
        Collection<Livros> livro = new HashSet<>(dao.buscarLista());
        livro.add(new Livros());
        Livros livreta = new Livros();
        teste(livreta.getTitulo());
        teste(livreta.getIsbn());
        teste(livreta.getAutor());
    }

    public static void teste(Object o) {
        System.out.println(o);
    }

}
