/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.business.model;

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
@Table(name="teacherBorrow")
@NamedQueries({
@NamedQuery(name = "TeacherBorrow.findAll", query = "SELECT tb FROM TeacherBorrow tb"),
    @NamedQuery(name = "TeacherBorrow.findById", query = "SELECT tb FROM TeacherBorrow tb WHERE tb.id = :id"),
    @NamedQuery(name = "TeacherBorrow.findByDateBorrow", query = "SELECT tb FROM TeacherBorrow tb WHERE tb.dateBorrow = :dateBorrwow"),
    @NamedQuery(name = "TeacherBorrow.findByDateDue", query = "SELECT tb FROM TeacherBorrow tb WHERE tb.dateDue = :dateDue"),
    @NamedQuery(name = "TeacherBorrow.findByDateReturn", query = "SELECT tb FROM TeacherBorrow tb WHERE tb.dateReturn = :dateReturn")
   })
public class TeacherBorrow implements Serializable {
    private IntegerProperty id;
    private ObjectProperty<Date> dateBorrow;
    private ObjectProperty<Date> dateDue;
    private ObjectProperty<Date> dateReturn;
    private ObjectProperty<Teacher> teacher;
    private ListProperty<Book> books;
    public TeacherBorrow(){
        this.id = new SimpleIntegerProperty();
        this.teacher = new SimpleObjectProperty<>();
        this.books = new SimpleListProperty<>();
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
    @OneToMany(mappedBy = "teacherBorrowed")
    @JoinColumn(name="book")
    public List<Book> getBorrowedBooks(){
           return this.books.get();
   }
    public void setBorrowedBooks(List<Book> books){
       ObservableList<Book> bookList = FXCollections.observableArrayList(books);
        this.books.set(bookList);
   }
    @ManyToOne
    @JoinColumn(name="teacher")
    public Teacher getTeacher(){
        return this.teacher.get();
    }
    public void setTeacher(Teacher teacher){
        this.teacher.set(teacher);
    }
}

