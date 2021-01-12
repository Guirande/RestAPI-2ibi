package tk.meceap.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tk.meceap.db.entidade.Pais;
import tk.meceap.db.entidade.Regiao;
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
    
    public List<Pais> getAll(String where, String order){
        List<Pais> paises = new ArrayList<>();
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "SELECT r.nome as regiao, r.descricao as desc_regiao, sr.regiao_id, sr.nome as sub_regiao, sr.descricao as desc_sub_regiao, p.* "
                    + "FROM pais p "
                    + "INNER JOIN sub_regiao sr ON p.sub_regiao_id = sr.id "
                    + "INNER JOIN regiao r ON sr.regiao_id = r.id ";
            if(!where.isEmpty())
                query += " where " + where;
            if(!order.isEmpty())
                query += " order by " + order;
            
            System.out.println(query);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            Pais pais;
            
            while (rs.next()) {
                pais = new Pais(rs.getInt("id"), rs.getString("nome"), rs.getString("capital"), rs.getDouble("area"), null, 
                            new SubRegiao(rs.getInt("sub_regiao_id"), rs.getString("sub_regiao"), rs.getString("desc_sub_regiao"), 
                                new Regiao(rs.getInt("regiao_id"), rs.getString("regiao"), rs.getString("desc_regiao"))));
                
                paises.add(pais);
                
            }
        } catch (Exception e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
        return paises;
    }
    
    public Pais get(int id){
        Pais pais = null;
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "SELECT r.nome as regiao, r.descricao as desc_regiao, sr.regiao_id, sr.nome as sub_regiao, sr.descricao as desc_sub_regiao, p.* "
                    + "FROM pais p "
                    + "INNER JOIN sub_regiao sr ON p.sub_regiao_id = sr.id "
                    + "INNER JOIN regiao r ON sr.regiao_id = r.id  where id="+id+";";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()) {
                pais = new Pais(rs.getInt("id"), rs.getString("nome"), rs.getString("capital"), rs.getDouble("area"), null, 
                            new SubRegiao(rs.getInt("sub_regiao_id"), rs.getString("sub_regiao"), rs.getString("desc_sub_regiao"), 
                                new Regiao(rs.getInt("regiao_id"), rs.getString("regiao"), rs.getString("desc_regiao"))));
                
            }
        } catch (Exception e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
        return pais;
    }
    
    public Pais addPais(Pais pais){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "INSERT INTO pais(sub_regiao_id, nome, capital, area) VALUES(?,?,?,?);";
            
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, pais.getSubRegiaoId());
            ps.setString(2, pais.getNome());
            ps.setString(3, pais.getCapital());
            ps.setDouble(4, pais.getArea());
            
            ps.execute(); 
            ResultSet rs = ps.getGeneratedKeys();
                        
            if(rs.next()){
                pais.setId(rs.getInt(1));
                return pais;
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public boolean updatePais(Pais pais){
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
            
            if(rs > 0) return true;
        } catch (SQLException e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public boolean deletePais(Pais pais){
        try {
            Connection connection = Conexao.getConexao();
            
            String query = "DELETE FROM pais where id = ?;";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, pais.getId());
            
            int rs = ps.executeUpdate();
            
            if(rs > 0) return true;
        } catch (SQLException e) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
