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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@NamedQueries({
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByISBN", query = "SELECT b FROM Book b WHERE b.iSBN = :iSBN"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
   })
public class Book implements Serializable{
    private StringProperty ISBN;
    private StringProperty title;
    private ListProperty<Author> authors;
    private ObjectProperty<Publisher> publisher;
    private ObjectProperty<StudentBorrow> studenBorrow;
    private ObjectProperty<TeacherBorrow> teacherBorrow;
    public Book(){
        this.ISBN = new SimpleStringProperty();
        this.title = new SimpleStringProperty();
        this.authors = new SimpleListProperty<>();
        this.publisher = new SimpleObjectProperty<>();
        this.studenBorrow = new SimpleObjectProperty<>();
        this.teacherBorrow = new SimpleObjectProperty<>();
    }
    public Book(String ISBN, String title ){
        this();
        this.ISBN.set(ISBN);
        this.title.set(title);
       
    }
    
    @Id
    @Column(name = "isbn")
    public String getISBN(){
        return this.ISBN.get();
    }
    
    public void setISBN(String ISBN){
        this.ISBN.set(ISBN);
    }
    
    @Column(name= "title")
    public String getTitle(){
        return this.title.get();
    }
    
    public void setTitle(String title){
        this.title.set(title);
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="book_authors",
                joinColumns=@JoinColumn(name="book_id"),
                inverseJoinColumns=@JoinColumn(name="author_id"))
    public List<Author> getAuthors(){
        return this.authors.get();
    }  
    
    public void setAuthors(List<Author> authors){
        ObservableList<Author> a = FXCollections.observableArrayList(authors);
        this.authors.set(a);
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher")
    public Publisher getPublisher(){
        return this.publisher.get();
    }
    
    public void setPublisher(Publisher publisher){
        this.publisher.set(publisher);
    }
      @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="studentborrowed")
    public StudentBorrow getBorrowed(){
        return this.studenBorrow.get();
    }
    public void setBorrowed(StudentBorrow borrow){
        this.studenBorrow.set(borrow);
    }
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="teacherborrowed")
   public TeacherBorrow getTeacherBorrowed(){
      return this.teacherBorrow.get();
    }
    public void setTeacherBorrowed(TeacherBorrow tb){
       this.teacherBorrow.set(tb);
    }
}

