/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Item;
import model.ItemDao;
import model.Localizacao;
import model.Preco;
import model.Versao;

/**
 *
 * @author LucasPC
 */
@ManagedBean(name = "listar")
@RequestScoped
public class listarBeans implements Serializable {

    
    private int id;  
   
    private String nomedoitem;   
    
    private String descricao;
    
    private List<Versao> versao;
  
    private List<Localizacao> localizacao;
    
    private List<Preco> preco;

    /**
     * Creates a new instance of listarBeans
     */
    public listarBeans()
    {
      
    }
    
    public List<Item> listarItens()
    {
       ItemDao itemDao=new ItemDao();
       List<Item> item =itemDao.listarItem();
       for(int i=0;i<item.size();i++)
       {
          nomedoitem = item.get(i).getNomedoitem();
          descricao = item.get(i).getDescricao();
          versao = item.get(i).getVersao();
          localizacao= item.get(i).getLocalizacao();
          preco = item.get(i).getPreco();
       }
       return item;
            
    }
    
     public String getNomedoitem() {
        return nomedoitem;
    }

    public void setNomedoitem(String nomedoitem) {
        this.nomedoitem = nomedoitem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Versao> getVersao() {
        return versao;
    }

    public void setVersao(List<Versao> versao) {
        this.versao = versao;
    }

    public List<Localizacao> getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(List<Localizacao> localizacao) {
        this.localizacao = localizacao;
    }

    public List<Preco> getPreco() {
        return preco;
    }

    public void setPreco(List<Preco> preco) {
        this.preco = preco;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    

}
