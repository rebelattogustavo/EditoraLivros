package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.controller.PessoaController;
import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Pessoas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroLivro extends JFrame {
    private JButton VOLTARButton;
    private JButton CADASTRARButton;
    private JTextField tituloInput;
    private JTextField isbnInput;
    private JTextField qtdPagInput;
    private JPanel cadastroLivro;


    public CadastroLivro(Pessoas pessoa) {
        criarComponentes();
        CADASTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tituloInput.getText().isEmpty() || isbnInput.getText().isEmpty()
                        || qtdPagInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Há um ou mais campos vazios!\n" +
                            "Preencha todos os campos!");
                } else {
                    LivrosController controller = new LivrosController();
                    try{
                        controller.cadastrar(tituloInput.getText(), Integer.parseInt(isbnInput.getText()),
                                Integer.parseInt(qtdPagInput.getText()), pessoa);
                        dispose();
                        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                        Menu menu = new Menu(Menu.userlogged());
                        menu.setVisible(true);
                    }catch (Exception exception){
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
            }
        });

        VOLTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu(pessoa);
                menu.setVisible(true);
            }
        });
    }

    private void criarComponentes() {
        setContentPane(cadastroLivro);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }

}
