/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Siddharth
 */

/**
 *  THIS IS THE ENTRY POINT OF THE PROGRAM. I've set this class as the main class in the project's classpath. 
 *
 */
public class MainClass extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXMLpack/AppTwoFXML.fxml")); //this is how your main class will load the fxml file
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //stage.setMaximized(true);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
