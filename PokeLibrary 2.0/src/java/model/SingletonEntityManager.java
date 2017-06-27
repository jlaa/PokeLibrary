/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author LucasPC
 */
public class SingletonEntityManager
{

   //create an object of SingleObject
   private static final EntityManagerFactory instance =  Persistence.createEntityManagerFactory("PokeLibrary");

   //make the constructor private so that this class cannot be
   //instantiated
   private SingletonEntityManager()
   {
       
   }

   //Get the only object available
   public static EntityManagerFactory getInstance(){
      return instance;
   }    
}
