package br.senai.sc.livros.view;

import javax.swing.*;

public class Menu extends JFrame{
    private JButton sairButton;
    private JPanel menu;

    public Menu(){
        criarComponentes();
    }


    private void criarComponentes() {
        setContentPane(menu);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }

}
