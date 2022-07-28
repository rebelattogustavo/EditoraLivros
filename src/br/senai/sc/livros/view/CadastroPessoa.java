package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.PessoaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPessoa extends JFrame{
    private JPanel cadastroPessoa;
    private JButton CADASTRARButton;
    private JButton VOLTARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public CadastroPessoa(){
        criarComponentes();
        VOLTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        });
        CADASTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaController controller = new PessoaController();
                controller.
            }
        });
    }


    private void criarComponentes() {
        setContentPane(cadastroPessoa);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }

}
