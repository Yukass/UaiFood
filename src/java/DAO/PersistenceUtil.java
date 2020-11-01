/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Yukas
 */
public class PersistenceUtil {
    
    private static EntityManagerFactory emf = null;
    
    public PersistenceUtil(){
    }
    
    public static EntityManager getEntityManager(){
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("uaifood");
        return emf.createEntityManager();
    }
    
    public static void close (EntityManager em){
    if(em != null) em.close();
    }
    
}