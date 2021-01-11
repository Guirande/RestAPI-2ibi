package tk.meceap.db.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author guirande
 */
public class Conexao {    
    public static Connection getConexao() {
        Connection connection = null;
        
        Properties p = Conexao.getProperties("db.properties");
        String url = p.getProperty("connector")  + "//" + p.getProperty("url")  + "/" + p.getProperty("db") + "?useSSL=" + p.getProperty("ssl");

        try {
            if(p != null){
                Class.forName(p.getProperty("driver"));
                connection = DriverManager.getConnection(url, p.getProperty("user"), p.getProperty("password"));
            }
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            String url1 = p.getProperty("connector") + "//" + p.getProperty("url") + "?useSSL=" + p.getProperty("ssl");
            
            try {
                connection = DriverManager.getConnection(url1, p.getProperty("user"), p.getProperty("password"));
                Statement statement = connection.createStatement();
                
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, "Creating database...");

                String sql = "CREATE DATABASE "+p.getProperty("db")+";";
                int rs = statement.executeUpdate(sql);
                
                if (rs > 0) {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, "Database created successfully...");
                    connection = DriverManager.getConnection(url, p.getProperty("user"), p.getProperty("password"));
                    statement = connection.createStatement();
                    
                    String sql1[] = getDB("db.sql").replace("\n", "").split(";");
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, sql);

                    for (String sqls : sql1) {
                        rs = statement.executeUpdate(sqls);
                        
                        if(rs > 0) 
                            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, "\n Query:"+sqls+" \nStatus:successfully...");
                        else 
                            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, "\n Query:"+sqls+" \nStatus:unsuccessfully...");
                    }
                    
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, "Database tables created successfully...");
                } else {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, "Could not create database...");
                }
            } catch (SQLException ex1) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return connection;
    }
    
    public static Properties getProperties(String file){
        try{
            Properties p = new Properties();
            p.load(Conexao.class.getResourceAsStream(file));            
            
            return p;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static String getDB(String file) {
        return new BufferedReader(new InputStreamReader(Conexao.class.getResourceAsStream(file)))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
