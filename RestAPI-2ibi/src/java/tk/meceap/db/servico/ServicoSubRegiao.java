package tk.meceap.db.servico;

import java.util.List;
import tk.meceap.db.dao.DAOSubRegiao;
import tk.meceap.db.entidade.SubRegiao;

/**
 *
 * @author guirande
 */
public class ServicoSubRegiao {
    
    private DAOSubRegiao daoSubRegiao;
    
    public ServicoSubRegiao() {
        daoSubRegiao = new DAOSubRegiao();
    }
    
    public List<SubRegiao> getAll(){
        return daoSubRegiao.getAll();
    }
    
    public SubRegiao get(int id){
        return daoSubRegiao.get(id);
    }
    
    public SubRegiao create(SubRegiao regiao) throws Exception{
        if(regiao == null) throw new NullPointerException("Regiao cant't be null");
        
        if(regiao.getNome()== null || regiao.getNome().length() == 0)
            throw new Exception("Nome can't be null");
                
        if(regiao.getDescricao()== null || regiao.getDescricao().length() == 0)
            throw new Exception("Descricao can't be null");
                        
        return daoSubRegiao.addSubRegiao(regiao);
    }
    
    
    public boolean update(SubRegiao regiao) throws Exception{
        if(regiao == null) throw new NullPointerException("Regiao cant't be null");
        
        if(regiao.getNome()== null || regiao.getNome().length() == 0)
            throw new Exception("Nome can't be null");
                
        if(regiao.getDescricao()== null || regiao.getDescricao().length() == 0)
            throw new Exception("Descricao can't be null");
        
        return daoSubRegiao.updateSubRegiao(regiao);
    }
    
    public boolean delete(SubRegiao regiao) throws Exception{
        if(regiao == null) throw new NullPointerException("Regiao cant't be null");
         
        return daoSubRegiao.deleteSubRegiao(regiao);
    }

}
