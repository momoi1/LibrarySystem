package librarysystem.business.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
////
////package test.model;
////
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
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



@Entity
@Table(name="studentBorrow")
@NamedQueries({
@NamedQuery(name = "StudentBorrow.findAll", query = "SELECT sb FROM StudentBorrow sb"),
    @NamedQuery(name = "StudentBorrow.findById", query = "SELECT sb FROM StudentBorrow sb WHERE sb.id = :id"),
    @NamedQuery(name = "StudentBorrow.findByDateBorrow", query = "SELECT sb FROM StudentBorrow sb WHERE sb.dateBorrow = :dateBorrwow"),
    @NamedQuery(name = "StudentBorrow.findByDateDue", query = "SELECT sb FROM StudentBorrow sb WHERE sb.dateDue = :dateDue"),
    @NamedQuery(name = "StudentBorrow.findByDateReturn", query = "SELECT sb FROM StudentBorrow sb WHERE sb.dateReturn = :dateReturn")
   })
public class StudentBorrow implements Serializable {
    private IntegerProperty id;
    private ObjectProperty<Date> dateBorrow;
    private ObjectProperty<Date> dateDue;
    private ObjectProperty<Date> dateReturn;
    private ObjectProperty<Student> student;
    private ListProperty<Book> borrowedBooks;
    
    public StudentBorrow(){
        this.id = new SimpleIntegerProperty();
        this.student = new SimpleObjectProperty<>();
        this.borrowedBooks = new SimpleListProperty<>(); 
        this.dateBorrow = new SimpleObjectProperty<>();
        this.dateDue = new SimpleObjectProperty<>();
        this.dateReturn = new SimpleObjectProperty<>();
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
    public Date getDateBorrow(){
        return this.dateBorrow.get();
    }
    public void tsetDateBorrow(Date dateBorrow){
        this.dateBorrow.set(dateBorrow);
    }
    public Date getDateDue(){
        return this.dateDue.get();
    }
    public void setDateDue(Date DateDue){
        this.dateDue.set(DateDue);
    }
    public Date getDateReturn(){
        return this.dateReturn.get();
    }
    public void setDateReturn(Date DateReturn){
        this.dateReturn.set(DateReturn);
    }
    @ManyToOne
    @JoinColumn(name="student")
    public Student getStudent(){
        return this.student.get();
    }
    public void setStudent(Student student){
       this.student.set(student);
    }
    
    
   @OneToMany(mappedBy = "borrowed")
    @JoinColumn(name="book")
     public List<Book> getBorrowedBooks(){
            return this.borrowedBooks.get();
    }
   public void setBorrowedBooks(List<Book> borrowedBooks){
       ObservableList<Book> list = FXCollections.observableArrayList(borrowedBooks);
        this.borrowedBooks.set(list);
   }
}
