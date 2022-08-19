package br.senai.sc.livros.view;

import br.senai.sc.livros.model.entities.Autores;
import br.senai.sc.livros.model.entities.Diretores;
import br.senai.sc.livros.model.entities.Pessoas;
import br.senai.sc.livros.model.entities.Revisores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private JButton sairButton;
    private JPanel menu;
    private JButton cadastrarLivroButton;
    private JButton cadastrarRevisorButton;
    private JButton listarAtividadesButton;
    private JButton listarLivrosButton;
    private JButton editarLivrosButton;
    private static Pessoas usuario;

    public static Pessoas userlogged(){
        return usuario;
    }

    public Menu(Pessoas pessoa) {
        usuario = pessoa;
        criarComponentes();
    }


    private void criarComponentes() {
        setContentPane(menu);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();

        cadastrarLivroButton.addActionListener(this);
        cadastrarLivroButton.setActionCommand("cadastrarLivro");
        listarLivrosButton.addActionListener(this);
        listarLivrosButton.setActionCommand("listarLivros");
        listarAtividadesButton.addActionListener(this);
        listarAtividadesButton.setActionCommand("listarAtividades");
        editarLivrosButton.addActionListener(this);
        editarLivrosButton.setActionCommand("editarLivros");
        cadastrarRevisorButton.addActionListener(this);
        cadastrarRevisorButton.setActionCommand("cadastrarRevisor");
        sairButton.addActionListener(this);
        sairButton.setActionCommand("sair");
        if(usuario instanceof Autores || usuario instanceof Revisores){
            cadastrarRevisorButton.setVisible(false);
        }
        if(usuario instanceof Diretores || usuario instanceof Revisores){
            cadastrarLivroButton.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cadastrarLivro")) {
            dispose();
            CadastroLivro cadastro = new CadastroLivro(usuario);
            cadastro.setVisible(true);
        } else if (e.getActionCommand().equals("cadastrarRevisor")) {
            dispose();
            CadastroPessoa cadastro = new CadastroPessoa();
            cadastro.setVisible(true);

        } else if (e.getActionCommand().equals("listarLivros")) {
            dispose();
            Estante estante = new Estante(1);
            estante.setVisible(true);
        } else if (e.getActionCommand().equals("listarAtividades")) {
            dispose();
            Estante estante = new Estante(2);
            estante.setVisible(true);
        } else if (e.getActionCommand().equals("editarLivros")) {
            dispose();
            Estante estante = new Estante(2);
            estante.setVisible(true);
        } else if (e.getActionCommand().equals("sair")) {
            usuario = null;
            dispose();
            Login login = new Login();
            login.setVisible(true);
        }

    }
}
