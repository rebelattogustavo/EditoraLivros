package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.PessoaController;
import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Gerentes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPessoa extends JFrame {
    private JPanel cadastroPessoa;
    private JButton CADASTRARButton;
    private JButton VOLTARButton;
    private JTextField nomeInput;
    private JTextField sobrenomeInput;
    private JTextField emailInput;
    private JTextField cpfInput;
    private JComboBox generoInput;
    private JTextField senhaInput;
    private JTextField confirmaSenhaInput;

    public CadastroPessoa() {
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

                if (senhaInput.getText().equals(confirmaSenhaInput.getText())) {
                    PessoaController pessoaController = new PessoaController();
                    pessoaController.cadastrar(nomeInput.getText(), sobrenomeInput.getText(), emailInput.getText(),
                            senhaInput.getText(), cpfInput.getText(), generoInput.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                    dispose();
                    Login login = new Login();
                    login.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Senhas não conferem");
                }
            }
        });
    }


    private void criarComponentes() {
        generoInput.setModel(new DefaultComboBoxModel(Genero.values()));
        setContentPane(cadastroPessoa);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }

}
