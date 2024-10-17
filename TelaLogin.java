import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaLogin extends JFrame {

    private JLabel loginLabel;
    private JLabel senhaLabel;
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton logarButton;

    public TelaLogin() {
        super("Tela de Login");
        setLayout(new FlowLayout()); 

        // Painel para o login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        loginLabel = new JLabel("Login:");
        loginField = new JTextField(20);
        loginPanel.add(loginLabel);
        loginPanel.add(loginField);
        add(loginPanel);

        // Painel para a senha
        JPanel senhaPanel = new JPanel();
        senhaPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);
        senhaPanel.add(senhaLabel);
        senhaPanel.add(senhaField);
        add(senhaPanel);

        // Painel para o botão (opcional, para centralizar)
        JPanel buttonPanel = new JPanel();
        logarButton = new JButton("Logar");
        buttonPanel.add(logarButton);
        add(buttonPanel); 
    }

    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaLogin.setSize(300, 150); 
        telaLogin.setVisible(true);
    }
}