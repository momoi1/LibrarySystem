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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author KENNETH
 */
@Entity
@Table(name="Authors")
@NamedQueries({
@NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findById", query = "SELECT a FROM Author a WHERE a.id = :id"),
    @NamedQuery(name = "Author.findByFirstName", query = "SELECT a FROM Author a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Author.findByLastName", query = "SELECT a FROM Author a WHERE a.lastName = :lastName")
   })
public class Author implements Serializable {
    private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private ListProperty<Book> books;
    public Author(){
        this.id = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.books = new SimpleListProperty<>();
    }
    public Author(String firstName,String lastName){
        this();
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }
    @Id
    @Column(name="id")
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
    public void setFirstName(String FirstName){
        this.firstName.set(FirstName);
    }
    @Column(name="lastname")
    public String getLastName(){
        return this.lastName.get();
    }
    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }
     @ManyToMany(mappedBy = "authors")
    public List<Book> getBooks(){
        return this.books.get();
    }
    public void setBooks(List<Book> books){
        ObservableList<Book> b = FXCollections.observableArrayList(books);
        this.books.set(b);
    }  
}
