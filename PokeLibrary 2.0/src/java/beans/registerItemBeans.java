/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Item;
import model.Localizacao;
import model.Preco;
import model.SessionContext;
import model.Usuario;
import model.UsuarioDao;
import model.Versao;

/**
 *
 * @author LucasPC
 */
@ManagedBean
@RequestScoped
public class registerItemBeans {

    private String nomedoitem;
    private String descricao;
    private String versaoDoitem;
    private String localizacaocomum;
    private String localizacaoDetalhada;
    private String formasdechegar;
    private double precoDoItem;
    private List<Versao> listVersao = new ArrayList();
    private List<Localizacao> listLocalizacao = new ArrayList();
    private List<Preco> listPreco = new ArrayList();
    private List<Item> listItem = new ArrayList();

    /**
     * Creates a new instance of registerItemBeans
     */
    public registerItemBeans() {

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

    public String getVersaoDoitem() {
        return versaoDoitem;
    }

    public void setVersaoDoitem(String versaoDoitem) {
        this.versaoDoitem = versaoDoitem;
    }

    public String getLocalizacaocomum() {
        return localizacaocomum;
    }

    public void setLocalizacaocomum(String localizacaocomum) {
        this.localizacaocomum = localizacaocomum;
    }

    public String getLocalizacaoDetalhada() {
        return localizacaoDetalhada;
    }

    public void setLocalizacaoDetalhada(String localizacaoDetalhada) {
        this.localizacaoDetalhada = localizacaoDetalhada;
    }

    public String getFormasdechegar() {
        return formasdechegar;
    }

    public void setFormasdechegar(String formasdechegar) {
        this.formasdechegar = formasdechegar;
    }

    public double getPrecoDoItem() {
        return this.precoDoItem;
    }

    public void setPrecoDoItem(double precoDoItem) {
        this.precoDoItem = precoDoItem;
    }

    public List<Versao> getVersao() {
        return listVersao;
    }

    public void setVersao(List<Versao> versao) {
        this.listVersao = versao;
    }

    public List<Localizacao> getLocalizacao() {
        return listLocalizacao;
    }

    public void setLocalizacao(List<Localizacao> localizacao) {
        this.listLocalizacao = localizacao;
    }

    public List<Preco> getPreco() {
        return listPreco;
    }

    public void setPreco(List<Preco> preco) {
        this.listPreco = preco;
    }

    public boolean adicionarVersao() {
        Versao versao = new Versao();
        versao.setVersao(versaoDoitem);
        Item item = (Item) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("item");
        listVersao = item.getVersao();
        if (listVersao == null) {
            listVersao = new ArrayList();
            listVersao.add(versao);
            item.setVersao(listVersao);
        } else {
            listVersao.add(versao);
            item.setVersao(listVersao);
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("item", item);
        return true;
    }

    public boolean adicionarPreco() {
        Preco preco = new Preco();
        preco.setPreco(precoDoItem);
        Item item = (Item) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("item");
        listPreco = item.getPreco();
        if (listPreco == null) {
            listPreco = new ArrayList();
            listPreco.add(preco);
            item.setPreco(listPreco);
        } else {
            listPreco.add(preco);
            item.setPreco(listPreco);
        }

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("item", item);
        return true;
    }

    public boolean adicionarLocalizacao() {
        Localizacao localizacao = new Localizacao();
        localizacao.setLoc(localizacaocomum);
        localizacao.setDescricaoLoc(localizacaoDetalhada);
        localizacao.setFormas(formasdechegar);
        Item item = (Item) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("item");
        listLocalizacao = item.getLocalizacao();
        if (listLocalizacao == null) {
            listLocalizacao = new ArrayList();
            listLocalizacao.add(localizacao);
            item.setLocalizacao(listLocalizacao);
        } else {
            listLocalizacao.add(localizacao);
            item.setLocalizacao(listLocalizacao);
        }

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("item", item);
        return true;
    }

    public String adicionarItem() {
        Item item = new Item();
        item.setNomedoitem(nomedoitem);
        item.setDescricao(descricao);

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("item", item);
        return "continuarCadastro?faces-redirect=true";
    }

    public String cadastrarItem() {
        adicionarVersao();
        adicionarLocalizacao();
        adicionarPreco();
        Item item = (Item) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("item");
       
        Usuario usuario = SessionContext.getInstance().getUsuarioLogado();
        List<Item> itemUsuario ;
        itemUsuario = usuario.getItens();
        itemUsuario.add(item);
        usuario.setItens(itemUsuario);
        
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.adicionarItem(usuario);      
        return "cadastroItemCompleto?faces-redirect=true";

    }

    public String adicionarNovamente() {
        adicionarVersao();
        adicionarLocalizacao();
        adicionarPreco();
        return "continuarCadastro?faces-redirect=true";
    }
}
