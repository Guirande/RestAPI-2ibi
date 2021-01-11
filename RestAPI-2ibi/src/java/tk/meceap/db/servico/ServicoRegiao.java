package tk.meceap.db.servico;

import java.util.List;
import tk.meceap.db.dao.DAORegiao;
import tk.meceap.db.entidade.Regiao;

/**
 *
 * @author guirande
 */
public class ServicoRegiao {
    private DAORegiao daoRegiao;
    
    public ServicoRegiao() {
        daoRegiao = new DAORegiao();
    }
    
    public List<Regiao> getAll(){
        return daoRegiao.getAll();
    }
    
    public Regiao get(int id){
        return daoRegiao.get(id);
    }
    
    public Regiao create(Regiao regiao) throws Exception{
        if(regiao == null) throw new NullPointerException("Regiao cant't be null");
        
        if(regiao.getNome()== null || regiao.getNome().length() == 0)
            throw new Exception("Nome can't be null");
                
        if(regiao.getDescricao()== null || regiao.getDescricao().length() == 0)
            throw new Exception("Descricao can't be null");
                        
        return daoRegiao.addRegiao(regiao);
    }
    
    
    public boolean update(Regiao regiao) throws Exception{
        if(regiao == null) throw new NullPointerException("Regiao cant't be null");
        
        if(regiao.getNome()== null || regiao.getNome().length() == 0)
            throw new Exception("Nome can't be null");
                
        if(regiao.getDescricao()== null || regiao.getDescricao().length() == 0)
            throw new Exception("Descricao can't be null");
        
        return daoRegiao.updateRegiao(regiao);
    }
    
    public boolean delete(Regiao regiao) throws Exception{
        if(regiao == null) throw new NullPointerException("Regiao cant't be null");
         
        return daoRegiao.deleteRegiao(regiao);
    }

}
