/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.lang.reflect.Field;
import java.util.List;
import java.lang.reflect.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Yukas
 */
public class DAO {
    
    private static DAO instance = new DAO();
    
    public static DAO getInstance(){
        return instance;
    }
    
    private DAO(){
        
    }
    
    public void salvar(Object objeto){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
         
        try{
            tx.begin();
            Method metodo = objeto.getClass().getMethod("getId");
          
            if( metodo != null){
                em.merge(objeto);
            }else{
                em.persist(objeto);
            }
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
    }
    
     public void excluir(Object objeto){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Method metodo = objeto.getClass().getMethod("getId");
            em.remove(em.getReference(objeto.getClass(), metodo.invoke(objeto)));
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
    }
     
     public void excluir(long id, Class classe){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
      
        Object obj = null;
        try{
            tx.begin();
            obj = em.find(classe, id);
            em.remove(em.getReference(obj.getClass(), id));
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
    }
     
     
       public Object getObjeto(long id, Class classe){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
      
        Object obj = null;
        try{
            tx.begin();
            obj = em.find(classe, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return obj;
    }
       
        
    public List<Object> getAllObjetos(Class classe){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Object> objects = null;
        try{
            tx.begin();
            TypedQuery<Object> query = em.createQuery("select cl from "+ classe.getName() +" cl", classe);
            objects = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return objects;
    }
    
    public Object getLogin(String email, Class classe){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Object objeto = null;
        try{
            tx.begin();
            TypedQuery<Object> query = em.createQuery("select c From "+ classe.getName() +" c where c."+ "email" +" LIKE :"+"email" , classe);        
            query.setParameter("email", email);
            objeto = query.getSingleResult();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
                return objeto;
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return objeto;
    }
   
    
   
    
    
}
