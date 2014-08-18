/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.presenter.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import librarysystem.business.service.BookService;
import librarysystem.presenter.Studentform.StudentFormPresenter;
import librarysystem.presenter.Studentform.StudentFormView;
import librarysystem.presenter.student.StudentPresenter;

/**
 * FXML Controller class
 *
 * @author KENNETH
 */
public class MainPresenter implements Initializable {
    @FXML
    private MenuItem addStudent;
    @FXML
    private MenuItem addBook;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane contentPane;
    StudentFormPresenter studentformpresenter;
    StudentPresenter studentpresenter;
    
    @Inject
    BookService bs;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      @FXML
    private void AddStudent(ActionEvent event){
        StudentFormView sfv = new StudentFormView();
        studentformpresenter = (StudentFormPresenter) sfv.getPresenter();
        contentPane.getChildren().clear();
        contentPane.getChildren().add(sfv.getView());
}
    
}
  
 
//    private void searchVoter(ActionEvent event) {
//        VoterView voterView = new VoterView();
//        voterPresenter = (VoterPresenter) voterView.getPresenter();
//        contentPane.getChildren().clear();
//        contentPane.getChildren().add(voterView.getView());
//    }
//
//    
//    @FXML
//    private void searchCandidate(ActionEvent event) {
//        
//        
//    }
//
//    @FXML
//    private void searchPartylist(ActionEvent event) {
//        
//        
//    } 
//}
