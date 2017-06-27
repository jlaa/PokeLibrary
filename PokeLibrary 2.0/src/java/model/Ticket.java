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
@Table(name = "Ticket_Table")
@Access(AccessType.FIELD)
public class Ticket implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET", nullable = false)
    private Integer id;
    
    @Column(name = "TITULO_ERRO", nullable = false)
    private String tituloErro;
    
    @Column(name = "DESCRICAO_ERRO", nullable = false)
    private String DescricaoErro;
    
    
    /*@ManyToMany(mappedBy = "Usuario_has_ticket")
    private List<Usuario> usuarios;*/
    
    //OBS: DEBATER SOBRE ESSA VARIAVEL
    private int idUsuario;

    public Ticket() {
    }

    public Ticket(int idUsuario, String DescricaoErro, String tituloErro) {
        this.DescricaoErro = DescricaoErro;
        this.tituloErro = tituloErro;
        this.idUsuario = idUsuario;
    }

    public void AdiconarTicket() {
        TicketDao ticket = new TicketDao();
        ticket.AdicionarTicket(idUsuario, DescricaoErro, tituloErro);
    }

}
