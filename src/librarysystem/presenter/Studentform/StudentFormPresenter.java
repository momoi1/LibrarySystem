/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.presenter.Studentform;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import librarysystem.business.model.Student;
import librarysystem.business.service.StudentService;
import librarysystem.presenter.student.StudentPresenter;
import librarysystem.presenter.student.StudentView;

/**
 * FXML Controller class
 *
 * @author KENNETH
 */
public class StudentFormPresenter implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
//    @FXML
//    private ComboBox<String> deparmentCBox;
    @FXML
    private Button saveButton;
    @FXML   
    private AnchorPane currentPane;
    private ObjectProperty<Student> selectedStudent;
    @Inject
    StudentService ss;
    StudentPresenter studentpresenter;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODo
    //    departmentBox();
        Student s = new Student();
        this.selectedStudent = new SimpleObjectProperty<>(s);
        this.firstNameField.textProperty().addListener(textFieldListeners(this.firstNameField));        
        this.lastNameField.textProperty().addListener(textFieldListeners(this.lastNameField));    
    }    
//    public void departmentBox(){
//        List<String> deparmentList = Arrays.asList("HighSchool", "Elementary","College");
//        ObservableList<String> deparmentList1 = FXCollections.observableArrayList(deparmentList);
//        deparmentCBox.setItems(deparmentList1);
//    }

    @FXML
    private void saveStudent(ActionEvent event){
        Student student = selectedStudent.get();
        student.setFirstName(firstNameField.getText());
        student.setLastName(lastNameField.getText());
      //  student.setDepartment(deparmentCBox.getSelectionModel().getSelectedItem());
        
        ss.save(student);
        StudentView studentView = new StudentView();
        studentpresenter = (StudentPresenter) studentView.getPresenter();
        AnchorPane contentPane = (AnchorPane) currentPane.getParent();
        contentPane.getChildren().add(studentView.getView());
    }
    public ObjectProperty<Student> getSelectedStudent(){
        return selectedStudent;
    }
    public void setSelectedStudent(ObjectProperty<Student> selectedStudent){
        this.selectedStudent = selectedStudent;
    }
    public ChangeListener<Student> selectedStudentListener(){
        ChangeListener<Student> selectedStudentListener = new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue){
                if(newValue != null){
                    firstNameField.setText(newValue.getFirstName());
                    lastNameField.setText(newValue.getLastName());
                   // deparmentCBox.getSelectionModel().select(newValue.getDepartment());
                }else{
                    
                }
            }
        };
        return selectedStudentListener;
    }
     public ChangeListener<String> textFieldListeners(TextField tf){
        final Pattern wholeNumberPattern = Pattern.compile("[A-Za-zñÑ]*");
        return new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observableValue, final String oldValue,
                                final String newValue) {
                if (!wholeNumberPattern.matcher(newValue).matches())
                    tf.setText(oldValue);
            }
        };
    }
    
    
}
