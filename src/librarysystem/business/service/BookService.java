/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.business.service;

import javax.inject.Inject;
import librarysystem.business.model.Book;

/**
 *
 * @author KENNETH
 */
public class BookService {
  
    @Inject
    EntityService es;
    
    
     public void save(Book book){
         es.getEntityTransaction().begin();
         Book merged = es.getEntityManager().merge(book);
         es.getEntityTransaction().commit();
    }
     public void remove(Book book){
         es.getEntityTransaction().begin();
         es.getEntityManager().remove(book);
         es.getEntityTransaction().commit();
     }
}
