/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.business.model;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author KENNETH
 */
@Entity
@Table(name="section")
@NamedQueries({
@NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s"),
    @NamedQuery(name = "Section.findById", query = "SELECT s FROM Section s WHERE s.id = :id"),
    @NamedQuery(name = "Section.findBySection", query = "SELECT s FROM Section s WHERE s.secName = :secName")
   })
public class Section implements Serializable {
    private IntegerProperty id;
    private StringProperty section;
    private ListProperty<Student> students;
    public Section(){
        this.id = new SimpleIntegerProperty();
        this.section = new SimpleStringProperty();
        this.students = new SimpleListProperty<>();
    }    
    public Section(String secName){
        this();
        this.section.set(secName);
    }
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return this.id.get();
    }
    
    public void setId(Integer id){
        this.id.set(id);
    }
    @Column(name="section")
    public String getSecName(){
        return this.section.get();
    }
    public void setSecName(String secName){
        this.section.set(secName);
    }
    
    //------------------------
    
    @OneToMany(mappedBy = "section")
    public List<Student> getStudent(){
         return this.students.get();
     }
    public void setStudent(List<Student> students){
        ObservableList<Student> student = FXCollections.observableArrayList(students);
        this.students.set(student);
    }
}
