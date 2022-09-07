package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.controller.PessoaController;
import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Livros;
import br.senai.sc.livros.model.entities.Pessoas;
import br.senai.sc.livros.model.service.LivroService;

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
    private LivroService service = new LivroService();


    public CadastroLivro(Pessoas pessoa, int opcao, String isbn) {
        criarComponentes(opcao, isbn);
        CADASTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tituloInput.getText().isEmpty() || isbnInput.getText().isEmpty()
                        || qtdPagInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Há um ou mais campos vazios!\n" +
                            "Preencha todos os campos!");
                } else {
                    LivrosController controller = new LivrosController();
                    if (opcao == 2) {
                        try {
                            Livros livroAtualizado = service.selecionar(Integer.parseInt(isbn));
                            livroAtualizado.setTitulo(tituloInput.getText());
                            livroAtualizado.setIsbn(Integer.parseInt(isbnInput.getText()));
                            livroAtualizado.setQtdPag(Integer.parseInt(qtdPagInput.getText()));
                            LivrosController livrosController = new LivrosController();
                            livrosController.editarLivro(isbn, 1);
                            dispose();
                            JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
                            Menu menu = new Menu(Menu.userlogged());
                            menu.setVisible(true);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage());
                        }

                    } else {
                        try {
                            controller.cadastrar(tituloInput.getText(), Integer.parseInt(isbnInput.getText()),
                                    Integer.parseInt(qtdPagInput.getText()), pessoa);
                            dispose();
                            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                            Menu menu = new Menu(Menu.userlogged());
                            menu.setVisible(true);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage());
                        }
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

    private void criarComponentes(int opcao, String isbn) {
        if (opcao == 2) {
            Livros livroAtualizado = service.selecionar(Integer.parseInt(isbn));
            tituloInput.setText(livroAtualizado.getTitulo());
            isbnInput.setText(Integer.toString(livroAtualizado.getIsbn()));
            qtdPagInput.setText(Integer.toString(livroAtualizado.getQtdPag()));
        }
        setContentPane(cadastroLivro);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }

}
