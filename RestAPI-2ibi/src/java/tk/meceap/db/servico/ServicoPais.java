package tk.meceap.db.servico;

import java.util.List;
import tk.meceap.db.dao.DAOPais;
import tk.meceap.db.entidade.Pais;

/**
 *
 * @author guirande
 */
public class ServicoPais {
    
    private DAOPais daoPais;
    
    public ServicoPais() {
        daoPais = new DAOPais();
    }
    
    public List<Pais> getAll(String where, String order){
        return daoPais.getAll(where, order);
    }
    
    public Pais get(int id){
        return daoPais.get(id);
    }
    
    public Pais create(Pais pais) throws Exception{
        System.out.println("\n\n"+pais);
        if(pais == null) throw new NullPointerException("Pais cant't be null");
        
        if(pais.getNome()== null || pais.getNome().length() == 0)
            throw new Exception("Nome can't be null");
                
        if(pais.getCapital()== null || pais.getCapital().length() == 0)
            throw new Exception("Capital can't be null");
        
        if(pais.getArea() < 0)
            throw new Exception("Area can't be less than 0");
                        
        return daoPais.addPais(pais);
    }
    
    
    public boolean update(Pais pais) throws Exception{
        System.out.println("\n\n"+pais);
        if(pais == null) throw new NullPointerException("Pais cant't be null");
        
        if(pais.getNome()== null || pais.getNome().length() == 0)
            throw new Exception("Nome can't be null");
                
        if(pais.getCapital() == null || pais.getCapital().length() == 0)
            throw new Exception("Capital can't be null-->"+pais.getCapital());
        
        if(pais.getArea() < 0)
            throw new Exception("Area can't be less than 0");
        
        return daoPais.updatePais(pais);
    }
    
    public boolean delete(Pais pais) throws Exception{
        if(pais == null) throw new NullPointerException("Pais cant't be null");
         
        return daoPais.deletePais(pais);
    }

}
