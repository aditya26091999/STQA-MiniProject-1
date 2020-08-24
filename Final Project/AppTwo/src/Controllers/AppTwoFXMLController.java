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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void adminLogin(ActionEvent event) {

        String admineml = adminEmail.getText();
        String admpwd = adminPass.getText();
        if(admineml.isEmpty() || admpwd.isEmpty()){
            adminLogBtn.setOnAction(e->ErrClass.ErrBox("Empty Fields", "You left some fields empty!"));
        }
    }

    @FXML
    private void userLogin(ActionEvent event) {
        String usereml = userEmail.getText();
        String userpwd = userPass.getText();
        //System.out.println("User email: "+usereml+" User password: "+userpwd);
        if(usereml.isEmpty() && userpwd.isEmpty()){
            userLogBtn.setOnAction(e->ErrClass.ErrBox("Empty Fields", "You left some fields empty!"));
        }
    }

    @FXML
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
