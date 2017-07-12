/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Item;
import model.ItemDao;
import model.Localizacao;
import model.Preco;
import model.Versao;
import model.Usuario;

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
    
    private Item item;

    private List<Versao> versao;

    private List<Localizacao> localizacao;

    private List<Preco> preco;
    
    private List<Item> items;
    
    private List<Usuario> usuarios;

    /**
     * Creates a new instance of listarBeans
     */
    public listarBeans() {
        ItemDao itemDao = new ItemDao();
        items = itemDao.listarItem();
        for (int i = 0; i < items.size(); i++) {
            nomedoitem = items.get(i).getNomedoitem();
            descricao = items.get(i).getDescricao();
            versao = items.get(i).getVersao();
            localizacao = items.get(i).getLocalizacao();
            preco = items.get(i).getPreco();
        }
    }
    

    
    public void removeItem(Integer id)
    {
        ItemDao itemDao = new ItemDao();
        itemDao.removeItem(id);        
    }
    
    public void pesquisarItem(Integer id)
    {
        ItemDao itemDao = new ItemDao();        
        item=itemDao.pesquisarItem(id);
        
        
        
    }
    
    public Item getItem()
    {
        return this.item;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItem(List<Item> item) {
        this.items = item;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    

}
