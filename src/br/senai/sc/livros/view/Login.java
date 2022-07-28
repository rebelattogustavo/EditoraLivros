package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.PessoaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements Runnable{
    private JTextField emailInput;
    private JPasswordField passwordInput;
    private JButton loginButton;
    private JButton cadastrarSeButton;
    private JPanel login;

    public Login(){
        criarComponentes();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaController controller = new PessoaController();
                if(controller.validalogin(emailInput.getText(), passwordInput.getText())){
//                    dispose();
                    Menu menu = new Menu();
                    menu.setVisible(true);
                }
            }
        });
        cadastrarSeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CadastroPessoa cadastro = new CadastroPessoa();
                cadastro.setVisible(true);
            }
        });
    }

    private void criarComponentes() {
        setContentPane(login);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }


    @Override
    public void run() {
        if(!isVisible()){
            setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "A janela já esta aberta");
        }
    }

    public static void main(String[] args) {
        Login programa = new Login();
        programa.run();
    }

}
