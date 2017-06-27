/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Usuario;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author LucasPC
 */
@ManagedBean(name = "login")
@RequestScoped
public class loginBeans implements Serializable {

    private String UsernameText;
    private String PasswordText;

    @NotEmpty(message = "O username não pode ser vazio")
    @Length(message = "O username não pode ter mais de 20 caracteres", max = 20)
    private String validarUsername;
    @NotEmpty(message = "O password não pode ser vazio")
    @Length(message = "O password não pode ter mais de 20 caracteres e"
            + " menos de 6 caracteres", max = 20, min = 6)
    private String validarPassword;

    private String valido;

    private boolean logar;

    /**
     * Creates a new instance of loginBeans
     */
    public loginBeans() {
        UsernameText = "Digite aqui o seu username";
        PasswordText = "Digite aqui o seu password";

    }

    public String getUsername() {
        return UsernameText;
    }

    public void setUsername(String Username) {
        this.UsernameText = Username;
    }

    public String getPassword() {
        return PasswordText;
    }

    public void setPassword(String Password) {
        this.PasswordText = Password;
    }

    public String getValidarUsername() {
        return validarUsername;
    }

    public void setValidarUsername(String validarUsername) {
        this.validarUsername = validarUsername;
    }

    public String getValidarPassword() {
        return validarPassword;
    }

    public void setValidarPassword(String validarPassword) {
        this.validarPassword = validarPassword;
    }

    public String getValido() {
        return this.valido;
    }

    public String validarUsuario() {

        Usuario usuario = new Usuario(validarUsername, validarPassword);
        logar = usuario.Authentication();
        if (logar == true) {
            return "homeLogado";
        }
        return "loginError";
    }

    public boolean getLogar() {
        return logar;
    }

    public void setLogar(boolean logar) {
        this.logar = logar;
    }

}
