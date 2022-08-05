package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.Autores;
import br.senai.sc.livros.model.entities.Livros;
import br.senai.sc.livros.model.entities.Pessoas;
import br.senai.sc.livros.model.entities.Status;
import br.senai.sc.livros.model.service.LivroService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estante extends JFrame {

    private JTable tabelaLivros;
    private JButton voltarButton;
    private JButton editarButton;
    private JPanel estante;
    private static int lista;

    public Estante(int botao) {
        lista = botao;
        criarComponentes();
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoas usuario = Menu.userlogged();
                if (usuario instanceof Autores) {
                } else {
                    ;
                }
            }
        });
    }

    private void criarComponentes() {
        LivrosController controller = new LivrosController();
        tabelaLivros.setModel(new DefaultTableModelArrayList(controller.buscarLista(lista)));
        if (lista == 1) {
            editarButton.setVisible(false);
        } else {
            String isbn = (String) tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0);
            controller.editarLivro(isbn);
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
