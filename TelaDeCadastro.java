import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeCadastro extends JFrame {

    public final JLabel lblNome;
    public final JTextField txtNome;
    public final JLabel lblEmail;
    public final JTextField txtEmail;
    public final JLabel lblSenha;
    public final JPasswordField txtSenha;
    public final JButton btnCadastrar;
    public final JButton btnCancelar;
    public final JLabel lblNotificacoes;

    public TelaDeCadastro() {
        super("Tela de Cadastro");
        setLayout(new GridLayout(5, 1, 5, 5));

        JPanel linhaNome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        txtNome = new JTextField(10);
        linhaNome.add(lblNome);
        linhaNome.add(txtNome);
        add(linhaNome);

        JPanel linhaEmail = new JPanel(new GridLayout(1, 2));
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        txtEmail = new JTextField(10);
        linhaEmail.add(lblEmail);
        linhaEmail.add(txtEmail);
        add(linhaEmail);

        JPanel linhaSenha = new JPanel(new GridLayout(1, 2));
        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        txtSenha = new JPasswordField(10);
        linhaSenha.add(lblSenha);
        linhaSenha.add(txtSenha);
        add(linhaSenha);

        JPanel linhaBotoes = new JPanel(new GridLayout(1, 2));
        btnCadastrar = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");
        linhaBotoes.add(btnCadastrar);
        linhaBotoes.add(btnCancelar);
        add(linhaBotoes);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (txtNome.getText().trim().length() == 0) {
                    lblNotificacoes.setText("É necessário digitar o nome.");
                    txtNome.requestFocus();
                    return;
                }

                if (txtEmail.getText().trim().length() == 0) {
                    lblNotificacoes.setText("É necessário digitar o email.");
                    txtEmail.requestFocus();
                    return;
                }

                if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) {
                    lblNotificacoes.setText("É necessário digitar a senha.");
                    txtSenha.requestFocus();
                    return;
                }

                String strSqlCadastrar = "INSERT INTO db_senac.tbl_senac (nome, email, senha) VALUES (?, ?, ?)";

                Connection conexao = MySQLConnector.conectar();
                if (conexao == null) {
                    lblNotificacoes.setText("Erro ao conectar ao banco de dados.");
                    return;
                }

                int resultado = 0;

                try (PreparedStatement pstmt = conexao.prepareStatement(strSqlCadastrar)) {
                    pstmt.setString(1, txtNome.getText());
                    pstmt.setString(2, txtEmail.getText());
                    pstmt.setString(3, String.valueOf(txtSenha.getPassword()));

                    resultado = pstmt.executeUpdate();

                    if (resultado > 0) {
                        lblNotificacoes.setText("Cadastro realizado com sucesso!");
                    } else {
                        lblNotificacoes.setText("Erro ao realizar o cadastro.");
                    }
                } catch (SQLException e) {
                    lblNotificacoes.setText("Erro: " + e.getMessage());
                } finally {
                    try {
                        if (conexao != null && !conexao.isClosed()) {
                            conexao.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaDeCadastro();
        });
    }
}
