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
import model.Localizacao;
import model.Preco;
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
    private List<Versao> versao = new ArrayList();
    private List<Localizacao> localizacao = new ArrayList();
    private List<Preco> preco = new ArrayList();

    /**
     * Creates a new instance of registerItemBeans
     */
    public registerItemBeans() {

    }

}
