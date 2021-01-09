package tk.meceap.db.entidade;

import tk.meceap.db.dao.DAOSubRegiao;

/**
 *
 * @author guirande
 */
public class Pais {
    private int id;
    private int subRegiaoId;
    private String nome;
    private String capital;
    private Double area;
    private SubRegiao subRegiao;

    public Pais() {
    }

    public Pais(int id, String nome, String capital, Double area, SubRegiao subRegiao) {
        this.id = id;
        this.nome = nome;
        this.capital = capital;
        this.area = area;
        this.subRegiao = subRegiao;
        this.subRegiaoId = subRegiao.getId();
    }

    public Pais(int id, int subRegiao, String nome, String capital, Double area) {
        DAOSubRegiao daoSubRegiao = new DAOSubRegiao();
        this.id = id;
        this.nome = nome;
        this.capital = capital;
        this.area = area;
        this.subRegiao = daoSubRegiao.get(subRegiao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubRegiaoId() {
        return subRegiaoId;
    }

    public void setSubRegiaoId(int subRegiaoId) {
        this.subRegiaoId = subRegiaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public SubRegiao getSubRegiao() {
        return subRegiao;
    }

    public void setSubRegiao(SubRegiao subRegiao) {
        this.subRegiao = subRegiao;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", subRegiaoId=" + subRegiaoId + ", nome=" + nome + ", capital=" + capital + ", area=" + area + ", subRegiao=" + subRegiao + '}';
    }
    
}
