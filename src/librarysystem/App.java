/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import librarysystem.presenter.main.MainView;

/**
 *
 * @author KENNETH
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        MainView mainView = new MainView();
        Scene scene = new Scene(mainView.getView());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
