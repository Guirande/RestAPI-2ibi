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
    
    public List<Pais> getAll(){
        return daoPais.getAll();
    }
    
    public Pais get(int id){
        return daoPais.get(id);
    }
    
    public void create(Pais pais) throws Exception{
        System.out.println("\n\n"+pais);
        if(pais == null) throw new NullPointerException("Pais cant't be null");
        
        if(pais.getNome()== null || pais.getNome().length() == 0)
            throw new Exception("Nome can't be null");
                
        if(pais.getCapital()== null || pais.getCapital().length() == 0)
            throw new Exception("Capital can't be null");
        
        if(pais.getArea() < 0)
            throw new Exception("Area can't be less than 0");
                        
        daoPais.addPais(pais);
    }
    
    
    public void update(Pais pais) throws Exception{
        System.out.println("\n\n"+pais);
        if(pais == null) throw new NullPointerException("Pais cant't be null");
        
        if(pais.getNome()== null || pais.getNome().length() == 0)
            throw new Exception("Nome can't be null");
                
        if(pais.getCapital() == null || pais.getCapital().length() == 0)
            throw new Exception("Capital can't be null-->"+pais.getCapital());
        
        if(pais.getArea() < 0)
            throw new Exception("Area can't be less than 0");
        
        daoPais.updatePais(pais);
    }
    
    public void delete(Pais pais) throws Exception{
        if(pais == null) throw new NullPointerException("Pais cant't be null");
         
        daoPais.deletePais(pais);
    }

}
