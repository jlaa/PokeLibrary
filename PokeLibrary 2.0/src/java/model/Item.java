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
@Table(name = "Item_Table")
@Access(AccessType.FIELD)
public class Item implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM", nullable = false)
    private Integer id;
    
    @Column(name = "NOME_ITEM", nullable = false)
    private String nomedoitem;

    @Column(name = "DESCRICAO_ITEM", nullable = false)
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Item_has_versao", joinColumns = {
        @JoinColumn(name = "ID_ITEM")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_VERSAO")
    })
    private List<Versao> versao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Item_has_localizacao", joinColumns = {
        @JoinColumn(name = "ID_ITEM")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_LOCALIZACAO")
    })
    private List<Localizacao> localizacao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Item_has_preco", joinColumns = {
        @JoinColumn(name = "ID_ITEM")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_PRECO")
    })
    private List<Preco> preco;    

    @ManyToMany(mappedBy = "itens")
    private List<Usuario> usuarios;
    
    public Item() {
    }

    public Item(String nomedoitem, String Descricao) {

        this.nomedoitem = nomedoitem;       
        this.descricao = Descricao;
        
    }   
    public String getNome()
    {
        return this.nomedoitem;
    }

    public String getDescricao()
    {
        return this.descricao;
    }
    public void setNome(String nomedoitem)
    {
        this.nomedoitem=nomedoitem;
    }
    public void setDescricao(String descricao)
    {
        this.descricao=descricao;
    }
   

}
