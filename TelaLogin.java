import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaLogin extends JFrame {

    private JLabel loginLabel;
    private JLabel senhaLabel;
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton btnLogar;
    private JLabel lblNotificaticaoes;

    public TelaLogin() {
        super("Tela de Login");
        setLayout(new FlowLayout()); 

        //JPanel loginPanel = new JPanel();
        setLayout(new FlowLayout(FlowLayout.CENTER)); 

        loginLabel = new JLabel("Login:");
        loginField = new JTextField(20);
       add(loginLabel);
        add(loginField);
        //add(loginPanel);

        //JPanel senhaPanel = new JPanel();
        //senhaPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);
       add(senhaLabel);
        add(senhaField);
        //add(senhaPanel);

        JPanel buttonPanel = new JPanel();
        btnLogar = new JButton("Logar");

        btnLogar.addActionListener(new ButtonHandle());
        
        buttonPanel.add(btnLogar);
        add(buttonPanel); 

        lblNotificaticaoes = new JLabel("Notificações");
        add(lblNotificaticaoes);
    }

    private class ButtonHandle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                Connection connection = MySQLConnector.conectar();
                String strSqlLogin = "select * from db_senac.tbl_senac where email" + loginField.getText() + "AND senha = " + String.valueOf(senhaField.getPassword());
                Statement stmSqlLogin = connection.createStatement();
                ResultSet rstLogin = stmSqlLogin.executeQuery(strSqlLogin);
                System.out.println("fico fora");
                if (rstLogin.next()) {
                    System.out.println("entrou");
                }
            } catch (Exception e) {
                System.err.println("error" + e);
            }


        }
    }
    
    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaLogin.setSize(300, 200); 
        telaLogin.setVisible(true);
    }
}

// class MySQLConnector {
    
//     public Connection conectar(String mysqlUser, String mysqlPassword) {
//         String mysqlHost = "172.17.2.217";
//         String mysqlDb = "db_senac";
//         String mysqlPort = "3306";
//         String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
//         Connection conn = null;

//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             conn = DriverManager.getConnection(mysqlUrl);
//             System.out.println("Conectouuuuuu");
//         } catch (Exception e) {
//             System.err.println("error: " + e);
//         }

//         return conn; 
//     }
// }
