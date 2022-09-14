package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.*;
import br.senai.sc.livros.model.service.LivroService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Estante extends JFrame {

    private JTable tabelaLivros;
    private JButton voltarButton;
    private JButton editarButton;
    private JPanel estante;
    private JButton revisarLivroButton;
    private static int lista;

    public Estante(int botao) throws SQLException {
        lista = botao;
        criarComponentes();
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivrosController controller = new LivrosController();
                String isbn = tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0).toString();
                if (Menu.userlogged() instanceof Revisores || Menu.userlogged() instanceof Diretores) {
                    ModalStatus modalStatus = new ModalStatus(isbn);
                    modalStatus.setVisible(true);
                } else {
                    dispose();
                    CadastroLivro cadastroLivro = null;
                    try {
                        cadastroLivro = new CadastroLivro(Menu.userlogged(), 2, isbn);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    cadastroLivro.setVisible(true);
                }
            }
        });
        revisarLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivrosController controller = new LivrosController();
                String isbn = tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0).toString();
                try {
                    controller.editarLivro(isbn, 5);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
                Estante estante = null;
                try {
                    estante = new Estante(lista);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                estante.setVisible(true);
            }
        });
    }

    private void criarComponentes() throws SQLException {
        LivrosController controller = new LivrosController();
        tabelaLivros.setModel(new DefaultTableModelCollection(controller.buscarLista(lista)));
        if (lista == 1) {
            editarButton.setVisible(false);
            revisarLivroButton.setVisible(false);
            if (Menu.userlogged() instanceof Revisores) {
                revisarLivroButton.setVisible(true);
            }
        } else {
            revisarLivroButton.setVisible(false);
        }
        tabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setContentPane(estante);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu(Menu.userlogged());
                menu.setVisible(true);
            }
        });
    }

}
