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
@Table(name = "Usuario_Table")
@Access(AccessType.FIELD)
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", nullable = false)
    private Integer id;

    @Column(name = "USERNAME", nullable = false)
    private String username;
    
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Usuario_has_item", joinColumns = {
        @JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_ITEM")
    })
    private List<Item> itens;
    
    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Usuario_has_ticket", joinColumns = {
        @JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_TICKET")
    })
    private List<Ticket> ticket;*/
    
    @OneToMany(mappedBy="cliente",fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)   
    private List<Glossario> glossario;

    public Usuario() {
    }

    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public void Adicionar() {
        UsuarioDao user = new UsuarioDao();
        user.adicionar(username, password, email);
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
