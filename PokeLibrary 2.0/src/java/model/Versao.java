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
@Table(name = "Versao_Table")
@Access(AccessType.FIELD)
public class Versao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VERSAO", nullable = false)
    private Integer id;
    
    @Column(name = "NOME_VERSAO", nullable = false)
    private String versaodojogo;
    
    @ManyToMany(mappedBy = "versao")
    private List<Item> itens;
    
    public Versao() {
    }
    
    public Versao(String versaodojogo)
    {
        this.versaodojogo=versaodojogo;
    }
    
    public String getVersao()
    {
        return this.versaodojogo;
    }
    
    public void setVersao(String versao)
    {
        this.versaodojogo=versao;
    }
    
}
