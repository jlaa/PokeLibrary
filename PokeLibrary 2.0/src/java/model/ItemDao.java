/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author LucasPC
 */
public class ItemDao implements InterfaceDaoItem {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PokeLibrary");

    @Override
    public int AdicionarItem(Item item, int id) {
        //modificar depois
        return 0;
    }

    public void pesquisarItem() {

    }

    public List<Item> listarItem() {
        EntityManager em = null;
        EntityTransaction et = null;     
        List<Item> items = new ArrayList();
        try {

            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            TypedQuery<Item> query = em.createQuery("SELECT i from Item i ", Item.class);           
            items = query.getResultList();
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
        return items;
    }
}
