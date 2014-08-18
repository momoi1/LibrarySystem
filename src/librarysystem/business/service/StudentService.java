/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.business.service;

import javax.inject.Inject;
import librarysystem.business.model.Student;

/**
 *
 * @author KENNETH
 */
public class StudentService {
    @Inject
    EntityService es;
    
    public void save(Student student){
        es.getEntityTransaction().begin();
         Student merged = es.getEntityManager().merge(student);
         es.getEntityTransaction().commit();
    }
}
