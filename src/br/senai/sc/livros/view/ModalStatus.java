package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.Autores;
import br.senai.sc.livros.model.entities.Revisores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ModalStatus extends JFrame {
    private JButton aguardandoRevisãoButton;
    private JButton aprovadoButton;
    private JButton aguardandoEdiçãoButton;
    private JButton publicadoButton;
    private JButton reprovadoButton;
    private JButton voltarButton;
    private JPanel modalStatus;

    public ModalStatus(String isbn) {
        criarComponentes();
        aguardandoRevisãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Estante estante = null;
                try {
                    estante = new Estante(2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                estante.setVisible(false);
                dispose();
                LivrosController controller = new LivrosController();
                try {
                    controller.editarLivro(isbn, 1);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                estante.setVisible(true);
            }
        });
        aguardandoEdiçãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivrosController controller = new LivrosController();
                try {
                    controller.editarLivro(isbn, 2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
                Estante estante = null;
                try {
                    estante = new Estante(2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                estante.setVisible(true);
            }
        });
        aprovadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivrosController controller = new LivrosController();
                try {
                    controller.editarLivro(isbn, 3);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
                Estante estante = null;
                try {
                    estante = new Estante(2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                estante.setVisible(true);
            }
        });
        reprovadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivrosController controller = new LivrosController();
                try {
                    controller.editarLivro(isbn, 4);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
                Estante estante = null;
                try {
                    estante = new Estante(2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                estante.setVisible(true);
            }
        });
        publicadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivrosController controller = new LivrosController();
                try {
                    controller.editarLivro(isbn, 5);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
                Estante estante = null;
                try {
                    estante = new Estante(2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                estante.setVisible(true);
            }
        });
    }

    private void criarComponentes() {
        aguardandoRevisãoButton.setVisible(false);
        aprovadoButton.setVisible(false);
        aguardandoEdiçãoButton.setVisible(false);
        publicadoButton.setVisible(false);
        reprovadoButton.setVisible(true);
        if (Menu.userlogged() instanceof Revisores) {
            aprovadoButton.setVisible(true);
            aguardandoEdiçãoButton.setVisible(true);
        } else {
            aguardandoRevisãoButton.setVisible(true);
            publicadoButton.setVisible(true);
        }
        setContentPane(modalStatus);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
