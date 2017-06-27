/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Usuario;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author LucasPC
 */
@ManagedBean(name = "register")
@RequestScoped
public class registerBeans {
    @NotEmpty(message = "O username não pode ser vazio")
    @Length(message = "O username não pode ter mais de 20 caracteres", max = 20)
    private String username;
    @NotEmpty(message = "O password não pode ser vazio")
    @Length(message = "O password não pode ter mais de 20 caracteres e"
            + " menos de 6 caracteres", max = 20, min = 6)
    private String password;
    @NotEmpty(message = "O email não pode ser vazio")
    @Email(message = "Email inválido")
    private String email;
    
    public registerBeans() {
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String cadastrarUsuario()
    {
        Usuario usuario = new Usuario(username,password,email);
        usuario.Adicionar();  
        return "registerCompleto";
    }
    

}
