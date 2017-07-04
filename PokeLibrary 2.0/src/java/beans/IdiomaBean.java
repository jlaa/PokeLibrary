/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author joao_dev
 */
@ManagedBean
@SessionScoped
public class IdiomaBean implements Serializable {

    /**
     * Creates a new instance of IdiomaBean
     */
    public IdiomaBean() {
    }

    private static final long serialVersionUID = 1L;

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {

        return locale;

    }

    public String getLanguage() {
        return locale.getLanguage();

    }

    public String changeLanguage(String language,String country) {
        locale = new Locale(language,country);        
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language,country));
        return " ";
    }

}
