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
@Table(name = "Preco_Table")
@Access(AccessType.FIELD)
public class Preco implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRECO", nullable = false)
    private Integer id;
    
    @Column(name = "PRECO_VERSAO", nullable = false)
    private double preco;
    
    @ManyToMany(mappedBy = "preco")
    private List<Item> itens;

    public Preco() {
    }
    
    public Preco(double preco)
    {
        this.preco=preco;
    }
    public double getPreco()
    {
        return this.preco;
    }
    public void setPreco(double preco)
    {
        this.preco=preco;
    }
}
