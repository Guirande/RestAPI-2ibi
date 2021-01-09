package tk.meceap.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tk.meceap.db.entidade.Pais;
import tk.meceap.db.entidade.SubRegiao;

/**
 *
 * @author guirande
 */
public class DAOPais {

    public SubRegiao getSubRegiao(List<SubRegiao> subRegioes, int id){
        for (SubRegiao subRegiao : subRegioes) {
            if(subRegiao.getId() == id) return subRegiao;
        }
        
        return null;
    }
    
    public List<Pais> getAll(){
        List<Pais> paises = new ArrayList<>();
        DAOSubRegiao daoRegiao = new DAOSubRegiao();
        List<SubRegiao> regioes = daoRegiao.getAll();
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "select * from pais;";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            Pais pais;
            
            while (rs.next()) {
                pais = new Pais(rs.getInt("id"), rs.getString("nome"), rs.getString("capital"), rs.getDouble("area"), getSubRegiao(regioes, rs.getInt("sub_regiao_id")));
                
                paises.add(pais);
                
            }
        } catch (Exception e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
        return paises;
    }
    
    public Pais get(int id){
        Pais pais = new Pais();
        DAOSubRegiao daoRegiao = new DAOSubRegiao();
        List<SubRegiao> regioes = daoRegiao.getAll();
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "select * from pais where id="+id+";";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()) {
                pais = new Pais(rs.getInt("id"), rs.getString("nome"), rs.getString("capital"), rs.getDouble("area"), getSubRegiao(regioes, rs.getInt("sub_regiao_id")));
            }
        } catch (Exception e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
        return pais;
    }
    
    public void addPais(Pais pais){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "INSERT INTO pais(sub_regiao_id, nome, capital, area) VALUES(?,?,?,?);";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, pais.getSubRegiaoId());
            ps.setString(2, pais.getNome());
            ps.setString(3, pais.getCapital());
            ps.setDouble(4, pais.getArea());
            
            int rs = ps.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void updatePais(Pais pais){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "UPDATE pais SET sub_regiao_id = ?, nome = ?, capital = ?, area = ? where id = ?;";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, pais.getSubRegiaoId());
            ps.setString(2, pais.getNome());
            ps.setString(3, pais.getCapital());
            ps.setDouble(4, pais.getArea());
            ps.setInt(5, pais.getId());
            
            int rs = ps.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void deletePais(Pais pais){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "DELETE FROM pais where id = ?;";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, pais.getId());
            
            int rs = ps.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
