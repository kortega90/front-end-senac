import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDePesquisa extends JFrame {
    public final JLabel lblPesquisa;
    public final JTextField txtPesquisa;
    public final JButton btnPesquisar;

    public final JLabel lblId;
    public final JTextField txtId;

    public final JLabel lblNome;
    public final JTextField txtNome;

    public final JLabel lblEmail;
    public final JTextField txtEmail;

    public final JButton btnPrimeiro;
    public final JButton btnAnterior;
    public final JButton btnProximo;
    public final JButton btnUltimo;

    public final JLabel lblNotificacoes;

    public TelaDePesquisa() {
        super("Tela de Pesquisa");
        setLayout(new GridLayout(7, 1, 5, 5));

        JPanel linhaPesquisa = new JPanel(new GridLayout(1, 2));
        txtPesquisa = new JTextField(60);
        lblPesquisa = new JLabel("Pesquisar:", SwingConstants.CENTER);
        linhaPesquisa.add(lblPesquisa);
        linhaPesquisa.add(txtPesquisa);

        add(linhaPesquisa);

        JPanel inputPesquisar = new JPanel(new GridLayout(1, 1));
        btnPesquisar = new JButton("Pesquisar");
        inputPesquisar.add(btnPesquisar);
        add(inputPesquisar);

        JPanel linhaId = new JPanel(new GridLayout(1, 2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        txtId = new JTextField(20);
        txtId.setEditable(false);
        linhaId.add(lblId);
        linhaId.add(txtId);
        add(linhaId);

        JPanel linhaNome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        txtNome = new JTextField(10);
        txtNome.setEditable(false);
        linhaNome.add(lblNome);
        linhaNome.add(txtNome);

        add(linhaNome);

        JPanel linhaEmail = new JPanel(new GridLayout(1, 2));
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        txtEmail = new JTextField(10);
        txtEmail.setEditable(false);
        linhaEmail.add(lblEmail);
        linhaEmail.add(txtEmail);
        add(linhaEmail);

        JPanel linhaBotoesNavegacao = new JPanel(new GridLayout(1, 4));
        btnPrimeiro = new JButton("<<");
        btnAnterior = new JButton("<");
        btnProximo = new JButton(">>");
        btnUltimo = new JButton(">");
        linhaBotoesNavegacao.add(btnPrimeiro);
        linhaBotoesNavegacao.add(btnAnterior);
        linhaBotoesNavegacao.add(btnProximo);
        linhaBotoesNavegacao.add(btnUltimo);
        add(linhaBotoesNavegacao);

        JPanel linhaBotoesNotificacoes = new JPanel(new GridLayout(1, 1));
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linhaBotoesNotificacoes.add(lblNotificacoes);
        add(linhaBotoesNotificacoes);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaDePesquisa();
        });
    }

}