package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.PessoaController;
import br.senai.sc.livros.model.entities.Genero;

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
                login.run();
            }
        });
        CADASTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomeInput.getText().isEmpty() || sobrenomeInput.getText().isEmpty() ||
                        emailInput.getText().isEmpty() || cpfInput.getText().isEmpty() || senhaInput.getText().isEmpty()
                        || confirmaSenhaInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Há um ou mais campos vazios!\n" +
                            "Preencha os campos novamente!");
                } else {
                    PessoaController controller = new PessoaController();
                    try {
                        controller.cadastrar(nomeInput.getText(), sobrenomeInput.getText(), emailInput.getText(),
                                senhaInput.getText(), cpfInput.getText(), (Genero) generoInput.getSelectedItem(),
                                confirmaSenhaInput.getText());
                        dispose();
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                        if (Menu.userlogged() == null) {
                            Login login = new Login();
                            login.setVisible(true);
                        } else {
                            Menu menu = new Menu(Menu.userlogged());
                            menu.setVisible(true);
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
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
