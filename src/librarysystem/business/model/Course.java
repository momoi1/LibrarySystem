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
@Table(name="course")
@NamedQueries({@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
    @NamedQuery(name = "Course.findByCourse", query = "SELECT c FROM Course c WHERE c.courseName = :courseName")
})
public class Course implements Serializable {
    private IntegerProperty id;
    private StringProperty course;
    private ListProperty<Student> students;
    public Course(){
        this.id = new SimpleIntegerProperty();
        this.course = new SimpleStringProperty();
        this.students = new SimpleListProperty<>();
    }
    public Course(String courseName){
        this();
        this.course.set(courseName);       
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
    @Column(name="course")
    public String getCourseName(){
        return this.course.get();
    }
    public void setCourseName(String courseName){
        this.course.set(courseName);
    }
    
    //---------------------------------------
    
    @OneToMany(mappedBy = "course")
    public List<Student> getStudent(){
         return this.students.get();
     }
    public void setStudent(List<Student> students){
        ObservableList<Student> student = FXCollections.observableArrayList(students);
        this.students.set(student);
    }
}
