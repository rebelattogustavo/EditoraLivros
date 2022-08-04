package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estante extends JFrame {

    private JTable tabelaLivros;
    private JButton voltarButton;
    private JButton editarButton;
    private JPanel estante;

    public Estante() {
        criarComponentes();

    }

    private void criarComponentes() {
        LivrosController controller = new LivrosController();
        tabelaLivros.setModel(new DefaultTableModelArrayList(controller.buscarLista()));
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
