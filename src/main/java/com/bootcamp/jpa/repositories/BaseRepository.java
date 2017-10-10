/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositories;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrateur
 * @param <T>
 */
public class BaseRepository<T> {
    
  private final EntityManager em;
  private final String unitPersistence;
  private final EntityManagerFactory emf;
  private final Class entityClass;

 
    public BaseRepository(String unitPersistence,  Class entityClass) {
        this.unitPersistence = unitPersistence;
        emf=Persistence.createEntityManagerFactory(this.unitPersistence);
        this.em=emf.createEntityManager();
        this.entityClass = entityClass;
    }
    
    public EntityManager getEntityManager(){
        return this.em;
    }
    
    public Boolean create(T entity) throws SQLException {
       getEntityManager().getTransaction().begin();
       getEntityManager().persist(entity);
       getEntityManager().getTransaction().commit();
       return true;
    }
    
    public void delete(T type){
        getEntityManager().getTransaction().begin();
              getEntityManager().remove(type);
         getEntityManager().getTransaction().commit();
              
    }
    
    public List<T> findByProperty(String propertyName, Object value) throws SQLException {
           
            String className = entityClass.getSimpleName(); 
            String str = "SELECT  ob FROM "+ className+ " ob WHERE ob."+propertyName +" = :param";
            Query query = getEntityManager().createQuery(str);
            query.setParameter("param", value);

            List<T> result = query.getResultList();
          
            return result;
        }
    
    public List<T> findAll(){
        
            String className = entityClass.getSimpleName(); 
            String s = "select ob FROM "+className+" ob";
            Query query = getEntityManager().createQuery(s);
            List<T> result = query.getResultList();
            return result;
    }
    
    public void update(T t){
        getEntityManager().getTransaction().begin();
       getEntityManager().merge(t);
       getEntityManager().getTransaction().commit();
    }
    
}
