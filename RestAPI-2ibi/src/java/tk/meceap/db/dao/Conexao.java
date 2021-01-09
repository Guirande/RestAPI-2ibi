package tk.meceap.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guirande
 */
public class Conexao {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/rest_api_2ibi?useSSL=false";
    private static String user = "root";
    private static String password = "StonerCorp";
    
    public static Connection getConexao() {
        Connection connection = null;
        
        try {
            Class.forName(driver);
            
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return connection;
    }
}
