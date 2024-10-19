
import java.sql.*;

public class MySQLConnector {
    
    public static Connection conectar() {
        String mysqlHost = "localhost";
        String mysqlDb = "db_senac";
        String mysqlUser = "root"; 
        String mysqlPassword = "senac@02";
        String mysqlPort = "3306";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(mysqlUrl);
        } catch (Exception e) {
            System.err.println("error" + e);
        }

        return conn; 
    }
}

