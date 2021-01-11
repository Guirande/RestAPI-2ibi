package tk.meceap.db.entidade;

import tk.meceap.db.dao.DAORegiao;

/**
 *
 * @author guirande
 */
public class SubRegiao {
    private int id;
    private int regiaoId;
    private String nome;
    private String descricao;
    private Regiao regiao;

    public SubRegiao() {
    }

    public SubRegiao(int id, String nome, String descricao, Regiao regiao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.regiao = regiao;
        this.regiaoId = regiao.getId();
    }
    

    public SubRegiao(int id, int regiao_id, String nome, String descricao) {
        DAORegiao daoRegiao = new DAORegiao();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.regiao = daoRegiao.get(regiao_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegiaoId() {
        return regiaoId;
    }

    public void setRegiaoId(int regiaoId) {
        this.regiaoId = regiaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "SubRegiao{" + "id=" + id + ", regiaoId=" + regiaoId + ", nome=" + nome + ", descricao=" + descricao + ", regiao=" + regiao + '}';
    }
}
