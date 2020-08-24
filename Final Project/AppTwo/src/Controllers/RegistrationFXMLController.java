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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Siddharth
 */
public class RegistrationFXMLController implements Initializable {

    @FXML
    private AnchorPane registrationScr;
    @FXML
    private Button createAccntBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField fnameField;
    @FXML
    private TextField lnameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField pwdField;
    @FXML
    private PasswordField confirmPwdField;
    @FXML
    private Button alreadyRegBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML   //this method will be called when user clicks the 'CREATE ACCOUNT' button
    private void createAcnt(ActionEvent event) {
        String ufname = fnameField.getText();
        String ulname = lnameField.getText();
        String uemail = emailField.getText();
        String upwd = pwdField.getText();
        String ucpwd = confirmPwdField.getText();
        if (ufname.isEmpty() || ulname.isEmpty() || uemail.isEmpty() || upwd.isEmpty() || ucpwd.isEmpty()){
            createAccntBtn.setOnAction(e->ErrClass.ErrBox("ERROR", "You left some fields blank!")); //this code will call an error dialog box if any of the fields are left blank
        }
    }

    @FXML   //this method will be called when user clicks the 'CANCEL' button
    private void exitWindow(ActionEvent event) {
        System.exit(0);
    }

    @FXML   //This method is called when user clicks the 'ALREADY REGISTERED?' button
    private void AlreadyReg(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLpack/AppTwoFXML.fxml")); //loads the login page fxml and saves it into a Parent instance.
            Stage stage = (Stage)emailField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RegistrationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
