package tk.meceap.db.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guirande
 */
public class Conexao {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    
    public static Connection getConexao() {
        Connection connection = null;
        
        try {
            getProperties();
            Class.forName(driver);
            
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return connection;
    }
    
    public static void getProperties(){
        try(FileReader reader = new FileReader("db/db.properties")){
            Properties p = new Properties();
            p.load(reader);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            user = p.getProperty("user");
            password = p.getProperty("password");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
