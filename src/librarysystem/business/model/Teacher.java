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
@Table(name="teacher")
@NamedQueries({
@NamedQuery(name = "Teacher.findAll", query = "SELECT te FROM Teacher te"),
    @NamedQuery(name = "Teacher.findById", query = "SELECT te FROM Teacher te WHERE te.id = :id"),
    @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT te FROM Teacher te WHERE te.firstName = :firstName"),
    @NamedQuery(name = "Teacher.findByLastName", query = "SELECT te FROM Teacher te WHERE te.lastName = :lastName")
   })
public class Teacher implements Serializable {
    private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private ListProperty<TeacherBorrow> teacherBorrowed;
      private ObjectProperty<Department> department;
  public Teacher(){
      this.id = new SimpleIntegerProperty();
      this.firstName = new SimpleStringProperty();
      this.lastName = new SimpleStringProperty();
      this.teacherBorrowed = new SimpleListProperty<>();
      this.department = new SimpleObjectProperty<>();
      
  }
  public Teacher(String firstName, String lastName){
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
    @Column(name = "firstname")
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
      
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    public List<TeacherBorrow> getTeacherBorrowed(){
            return this.teacherBorrowed.get();
    }
    public void setTeacherBorrowed(List<TeacherBorrow> teacherBorrowed){
        ObservableList<TeacherBorrow> list = FXCollections.observableArrayList(teacherBorrowed);
        this.teacherBorrowed.set(list);
    }
     @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department")
    
    public Department getDepartment(){
        return this.department.get();
    }
    public void setDepartment(Department department){
        this.department.set(department);
    }
}
