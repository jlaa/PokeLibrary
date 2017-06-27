/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.ListIterator;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "Glossario_Table")
@Access(AccessType.FIELD)
public class Glossario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GLOSSARIO", nullable = false)
    private int id_glossario;
    
    @Column(name = "VERBETE", nullable = false)
    private String Verbete;
    
    @Column(name = "DESCRICAO_VERBETE", nullable = false)
    private String DescricaoVerbete;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO_GLOSSARIO", referencedColumnName = "ID_USUARIO")
    private Usuario cliente;
     
    //OBS: DEBATER SOBRE ESSA VARIAVEL
    private int id_usuario;

    public Glossario() {

    }

    //id do usuário para saber quem foi que adicionou aquele glossario

    public Glossario(int id_glossario, String Verbete, String DescricaoVerbete, int id_usuario) {
        this.DescricaoVerbete = DescricaoVerbete;
        this.Verbete = Verbete;
        this.id_glossario = id_glossario;
        this.id_usuario = id_usuario;
    }

    public String[] getDados() {
        GlossarioDao glossarioDao = new GlossarioDao();
        ArrayList<Glossario> dados = glossarioDao.getDados();
        ListIterator itr = dados.listIterator();
        String verbete = null;
        String descricaoVerbete = null;
        String[] glossario = new String[dados.size()];
        // aqui tem que haver uma separação dos dados
        for (int i = 0; itr.hasNext(); i++) {
            Glossario aux;
            aux = dados.get(i);
            verbete = aux.Verbete;
            descricaoVerbete = aux.DescricaoVerbete;
            verbete = verbete + " ' " + descricaoVerbete;
            glossario[i] = verbete;
            itr.next();
        }
        return glossario;
    }

    public String getVerbete() {
        String verbete = this.Verbete;

        return verbete;
    }

    public String getDescricao() {
        String Descricao = this.DescricaoVerbete;

        return Descricao;
    }

    /*public void AdiconarVerbete()
     {
     GlossarioDao glossario=new GlossarioDao();
     glossario.AdicionarVerbete(id_glossario, Verbete, DescricaoVerbete,id_usuario);
     }*/
}
