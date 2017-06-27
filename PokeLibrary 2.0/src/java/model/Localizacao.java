/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "Localizacao_Table")
@Access(AccessType.FIELD)
public class Localizacao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOCALIZACAO", nullable = false)
    private Integer id;
    
    @Column(name = "NOME_LOC", nullable = false)
    private String localizacaocomum;
    
    @Column(name = "DESCRICAO_LOC", nullable = false)
    private String localizacaoDetalhada;
    
    @Column(name = "FORMAS_DE_CHEGAR", nullable = false)
    private String formasdechegar;
    
    @ManyToMany(mappedBy = "localizacao")
    private List<Item> itens;

    public Localizacao() {
    }
    
    public Localizacao(String localizacaocomum,String localizacaoDetalhada,String formasdechegar)
    {
        this.localizacaocomum=localizacaocomum;
        this.localizacaoDetalhada=localizacaoDetalhada;
        this.formasdechegar=formasdechegar;
    }
    public void setFormas(String formas)
    {
        this.formasdechegar=formas;
    }
    public void setLoc(String loc)
    {
        this.localizacaocomum=loc;
    }
    public void setDescricaoLoc(String descricao)
    {
        this.localizacaoDetalhada=descricao;
    }
    
    public String getFormas()
    {
        return this.formasdechegar;
    }
    
    public String getLoc()
    {
        return this.localizacaocomum;
    }
    public String getDescricaoLoc()
    {
        return this.localizacaoDetalhada;
    }
}
