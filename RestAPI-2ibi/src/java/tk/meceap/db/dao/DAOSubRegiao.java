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
import tk.meceap.db.entidade.SubRegiao;

/**
 *
 * @author guirande
 */
public class DAOSubRegiao {

    public Regiao getRegiao(List<Regiao> regioes, int id){
        for (Regiao regiao : regioes) {
            if(regiao.getId() == id) return regiao;
        }
        
        return null;
    }
    
    public List<SubRegiao> getAll(){
        List<SubRegiao> subRegioes = new ArrayList<>();
        DAORegiao daoRegiao = new DAORegiao();
        List<Regiao> regioes = daoRegiao.getAll();
        
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "select * from sub_regiao;";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            SubRegiao subRegiao;
            
            while (rs.next()) {
                subRegiao = new SubRegiao(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), getRegiao(regioes, rs.getInt("regiao_id")));
                
                subRegioes.add(subRegiao);
            }
        } catch (Exception e) {
            Logger.getLogger(DAOSubRegiao.class.getName()).log(Level.SEVERE, null, e);
        }
        return subRegioes;
    }
    
    public SubRegiao get(int id){
        SubRegiao subRegiao = new SubRegiao();
        DAORegiao daoRegiao = new DAORegiao();
        List<Regiao> regioes = daoRegiao.getAll();
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "select * from sub_regiao where id ="+id+";";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()) {
                subRegiao = new SubRegiao(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), getRegiao(regioes, rs.getInt("regiao_id")));                                
            }
        } catch (Exception e) {
            Logger.getLogger(DAOSubRegiao.class.getName()).log(Level.SEVERE, null, e);
        }
        return subRegiao;
    }
    
    public void addSubRegiao(SubRegiao subRegiao){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "INSERT INTO sub_regiao(regiao_id, nome, descricao) VALUES(?,?,?);";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, subRegiao.getRegiaoId());
            ps.setString(2, subRegiao.getNome());
            ps.setString(3, subRegiao.getDescricao());
            
            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DAOSubRegiao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void updateSubRegiao(SubRegiao subRegiao){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "UPDATE sub_regiao SET regiao_id = ?, nome = ?, descricao = ? where id = ?;";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, subRegiao.getRegiaoId());
            ps.setString(2, subRegiao.getNome());
            ps.setString(3, subRegiao.getDescricao());
            ps.setInt(4, subRegiao.getId());
            
            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DAOSubRegiao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void deleteSubRegiao(SubRegiao subRegiao){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "DELETE FROM sub_regiao where id = ?;";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, subRegiao.getId());
            
            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DAOSubRegiao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
