/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import alertBoxes.ErrClass;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Siddharth
 */

/**
 * THE BELOW TEXTFIELDS AND BUTTONS ARE A PART OF LOGIN PAGE. THE FXML FILE AUTOMATICALLY GENERATES THE METHODS AND VARIABLES WHENEVER THE 
 * SCENE BUILDER IS UPDATED. YOU JUST NEED TO RIGHT CLICK THE FXML DOC AND CLICK ADD CONTROLLER FOR THE FXML DOC.
 */
public class AppTwoFXMLController implements Initializable {

    @FXML
    private TextField adminEmail;
    @FXML
    private PasswordField adminPass;
    @FXML
    private TextField userEmail;
    @FXML
    private PasswordField userPass;
    @FXML
    private Button adminLogBtn;
    @FXML
    private Button userLogBtn;
    @FXML
    private Button UserCreateAccnNtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {//ignore this method
        // TODO
    }

    @FXML   //this is the method that'll be called when user presses login button on the ADMIN side
    private void adminLogin(ActionEvent event) {

        String admineml = adminEmail.getText();
        String admpwd = adminPass.getText();
        if(admineml.isEmpty() || admpwd.isEmpty()){
            adminLogBtn.setOnAction(e->ErrClass.ErrBox("Empty Fields", "You left some fields empty!"));
        }
    }

    @FXML   ///this is the method that'll be called when user presses login button on the USER side
    private void userLogin(ActionEvent event) {
        String usereml = userEmail.getText();
        String userpwd = userPass.getText();
        //System.out.println("User email: "+usereml+" User password: "+userpwd);
        if(usereml.isEmpty() && userpwd.isEmpty()){
            ErrClass.ErrBox("Empty Fields", "You left some fields Empty!");
        }
    }

    @FXML   //this method will be called when user presses the CREATE ACCOUNT button on the USER side.
    private void createAccn(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLpack/RegistrationFXML.fxml")); //load the registration page FXML file for view
            Stage stage = (Stage)userPass.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            //stage.setMaximized(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AppTwoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
