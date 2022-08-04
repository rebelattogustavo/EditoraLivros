package br.senai.sc.livros.view;

import br.senai.sc.livros.model.entities.Livros;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DefaultTableModelArrayList extends AbstractTableModel {

    ArrayList<Livros> dados;
    String [] colunas;

    DefaultTableModelArrayList(ArrayList<Livros> lista) {
        this.dados = lista;
        colunas = new String[] {"Isbn", "Titulo", "QtdPag", "Autor", "Editora", "Status"};
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
            case 4 -> livro.getEditora();
            default -> livro.getStatus();
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

//        private static final long serialVersionUID = 1L;
//        private String[] colunas = {"Titulo", "Autor", "Editora", "Status", "Isbn", "Qtd.Pag"};
//        private Object[][] dados = {};
//
//        public DefaultTableModelArrayList(Object[][] dados) {
//            this.dados = dados;
//        }
//
//        @Override
//        public int getColumnCount() {
//            return colunas.length;
//        }
//
//        @Override
//        public int getRowCount() {
//            return dados.length;
//        }
//
//        @Override
//        public String getColumnName(int column) {
//            return colunas[column];
//        }
//
//        @Override
//        public Object getValueAt(int row, int column) {
//            return dados[row][column];
//        }
//
//        @Override
//        public boolean isCellEditable(int row, int column) {
//            return false;
//        }
//
//        @Override
//        public void setValueAt(Object value, int row, int column) {
//            dados[row][column] = value;
//            fireTableCellUpdated(row, column);
//        }
//
//        public void addRow(Object[] row) {
//            Object[][] newDados = new Object[dados.length + 1][colunas.length];
//            for (int i = 0; i < dados.length; i++) {
//                for (int j = 0; j < colunas.length; j++) {
//                    newDados[i][j] = dados[i][j];
//                }
//            }
//            newDados[dados.length][0] = row[0];
//            newDados[dados.length][1] = row[1];
//            newDados[dados.length][2] = row[2];
//            newDados[dados.length][3] = row[3];
//            newDados[dados.length][4] = row[4];
}
