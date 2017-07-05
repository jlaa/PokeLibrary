/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucas
 */
public class UsuarioDao implements InterfaceUsuarioDao {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PokeLibrary");
    
    @Override
    public void adicionar(String NomeUsuario, String Password, String Email) {
        
        EntityManager em = null;
        EntityTransaction et = null;
        Usuario cliente = new Usuario(NomeUsuario, Password, Email);
        try {

            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(cliente);            
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }          
        }
    }
    
    
    @Override
    public Usuario Autenticacao(String username, String password) {
        boolean retorno = false;

        EntityManager em = null;
        EntityTransaction et = null;
        Usuario user= new Usuario();
        try {

            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            TypedQuery<Usuario> query= em.createQuery("SELECT u from Usuario u where u.username like ?1 and  u.password like ?2",Usuario.class); 
            query.setParameter(1, username);
            query.setParameter(2, password);           
            user=query.getSingleResult();
            if(user !=null){
                return user;
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            
            }
            
        }
        return user;
    }
}
