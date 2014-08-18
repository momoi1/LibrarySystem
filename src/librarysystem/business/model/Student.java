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
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author KENNETH
 */
@Entity
@Table(name = "student")
@NamedQueries({
@NamedQuery(name = "Student.findAll", query = "SELECT st FROM Student st"),
    @NamedQuery(name = "Student.findById", query = "SELECT st FROM Student st WHERE st.id = :id"),
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT st FROM Student st WHERE st.firstName = :firstName"),
    @NamedQuery(name = "Student.findByLastName", query = "SELECT st FROM Student st WHERE st.lastName = :lastName")
   })
public class Student implements Serializable {
    private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private ListProperty<StudentBorrow> studentBorrowed;
    private ObjectProperty<Section> section;
    private ObjectProperty<Department> department;
    private ObjectProperty<Course> course;
       public Student(){
        this.id = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty(); 
        this.studentBorrowed = new SimpleListProperty<>();
        this.section = new SimpleObjectProperty<>();
        this.department = new SimpleObjectProperty<>();
        this.course = new SimpleObjectProperty<>();
    }
       public Student(String firstName,String lastName){
        this();
        this.firstName.set(firstName);
        this.lastName.set(lastName);        
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
    @Column(name="firstname")
    public String getFirstName(){
        return this.firstName.get();
    }
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
    @Column(name="lastname")
     public String getLastName(){
        return this.lastName.get();
    }
    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    public List<StudentBorrow> getStudentBorrowed(){
            return this.studentBorrowed.get();
    }
    public void setStudentBorrowed(List<StudentBorrow> StudentBorrows){
        ObservableList<StudentBorrow> StudentBorrow = FXCollections.observableArrayList(StudentBorrows);
        this.studentBorrowed.set(StudentBorrow);
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section")
    public Section getSection(){
        return this.section.get();
    }
    public void setSection(Section section){
        this.section.set(section);
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department")
    
    public Department getDepartment(){
        return this.department.get();
    }
    public void setDepartment(Department department){
        this.department.set(department);
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course")
    public Course getCourse(){
        return this.course.get();
    }
    public void setCourse(Course course){
        this.course.set(course);
    }
}
