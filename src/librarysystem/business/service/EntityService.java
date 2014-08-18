/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.business.service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author KENNETH
 */
public class EntityService {
    private EntityManager em;
    private EntityTransaction et;
    
    
    
    
    @PostConstruct
    public void init(){
        this.em = (EntityManager) Persistence.createEntityManagerFactory("LibrarySystemPU").createEntityManager();
        this.et = em.getTransaction();
    }
    
    public EntityManager getEntityManager(){
        return this.em;
    }
    public EntityTransaction getEntityTransaction(){
        return this.et;
    }
}
