package tk.meceap.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tk.meceap.db.entidade.Regiao;

/**
 *
 * @author guirande
 */
public class DAORegiao {
    public List<Regiao> getAll(){
        List<Regiao> regioes = new ArrayList<>();
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "select * from regiao;";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            Regiao regiao;
            
            while (rs.next()) {
                regiao = new Regiao(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
                
                regioes.add(regiao);
                
            }
        } catch (Exception e) {
            Logger.getLogger(DAORegiao.class.getName()).log(Level.SEVERE, null, e);
        }
        return regioes;
    }
    
    public Regiao get(int id){
        Regiao regiao = new Regiao();
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "select * from regiao where id ="+id+";";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()) {
                regiao = new Regiao(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
                                
            }
        } catch (Exception e) {
            Logger.getLogger(DAORegiao.class.getName()).log(Level.SEVERE, null, e);
        }
        return regiao;
    }
    
    public void addRegiao(Regiao regiao){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "INSERT INTO regiao(nome, descricao) VALUES(?,?);";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, regiao.getNome());
            ps.setString(2, regiao.getDescricao());
            
            int rs = ps.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(DAORegiao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void updateRegiao(Regiao regiao){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "UPDATE regiao SET nome = ?, descricao = ? where id = ?;";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, regiao.getNome());
            ps.setString(2, regiao.getDescricao());
            ps.setInt(3, regiao.getId());
            
            int rs = ps.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(DAORegiao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void deleteRegiao(Regiao regiao){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "DELETE FROM regiao where id = ?;";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, regiao.getId());
            
            int rs = ps.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(DAORegiao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
