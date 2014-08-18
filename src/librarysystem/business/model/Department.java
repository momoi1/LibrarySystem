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
@Table(name ="department")
@NamedQueries({
@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findById", query = "SELECT d FROM Department d WHERE d.id = :id"),
    @NamedQuery(name = "Department.findByDepartment", query = "SELECT d FROM Department d WHERE d.deptName = :deptName")
   })
public class Department implements Serializable {
    private IntegerProperty id;
    private StringProperty deptName;
    private ListProperty<Student> students;
    private ListProperty<Teacher> teachers;
    public Department(){
        this.id = new SimpleIntegerProperty();
        this.deptName = new SimpleStringProperty();
        this.students = new SimpleListProperty<>();
        this.teachers = new SimpleListProperty<>();
    }
    public Department(String deptName){
        this.deptName.set(deptName);
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
    @Column(name ="department")
    public String getDeptName(){
        return this.deptName.get();
    }
    public void setDeptName(String deptName){
        this.deptName.set(deptName);
    }
    
    //-----------------------------------------------------
    
    @OneToMany(mappedBy = "department")
     public List<Student> getStudents(){
         return this.students.get();
     }
    public void setStudents(List<Student> students){
        ObservableList<Student> student = FXCollections.observableArrayList(students);
        this.students.set(student);
    }
    
    //--------------------------------------------
    
    @OneToMany(mappedBy = "department")
    public List<Teacher> getTeachers(){
         return this.teachers.get();
     }
    public void setTeachers(List<Teacher> teachers){
        ObservableList<Teacher> teacher = FXCollections.observableArrayList(teachers);
        this.teachers.set(teacher);
    }
}
