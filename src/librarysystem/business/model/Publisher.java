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
@Table(name="publisher")
@NamedQueries({
@NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p"),
    @NamedQuery(name = "Publisher.findById", query = "SELECT p FROM Publisher p WHERE p.id = :id"),
    @NamedQuery(name = "Publisher.findByPublisher", query = "SELECT p FROM Publisher p WHERE p.name = :name")
   })
public class Publisher implements Serializable {
     private IntegerProperty id;
    private StringProperty publisher;
    private ListProperty<Book> books;
   
    
    public Publisher(){
        this.id = new SimpleIntegerProperty();
        this.publisher = new SimpleStringProperty();
        this.books = new SimpleListProperty<>();
       
    }
    
    public Publisher(String name){
        this();
        this.publisher.set(name);
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
    
    @Column(name = "publisher")
    public String getName(){
        return this.publisher.get();
    }
    
    public void setName(String name){
        this.publisher.set(name);
    }
     @OneToMany(mappedBy = "publisher")
    public List<Book> getBooks(){
        return this.books.get();
    }
    
    public void setBooks(List<Book> books){
        ObservableList<Book> b = FXCollections.observableArrayList(books);
        this.books.set(b);
    }
}
