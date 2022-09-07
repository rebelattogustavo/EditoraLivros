package br.senai.sc.livros.view;

import br.senai.sc.livros.model.entities.Livros;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultTableModelCollection extends AbstractTableModel {

    List<Livros> dados;
    String[] colunas;

    DefaultTableModelCollection(Collection<Livros> lista) {
        this.dados = new ArrayList<>(lista);
        colunas = new String[]{"Isbn", "Titulo", "QtdPag", "Autor", "Editora", "Status"};
    }


    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livros livro = dados.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> livro.getIsbn();
            case 1 -> livro.getTitulo();
            case 2 -> livro.getQtdPag();
            case 3 -> livro.getAutor().getNome() + " " + livro.getAutor().getSobrenome();
            case 4 -> livro.getEditora().getNome();
            default -> livro.getStatus();
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }


}
