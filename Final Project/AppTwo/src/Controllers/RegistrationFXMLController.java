/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import alertBoxes.ErrClass;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createAcnt(ActionEvent event) {
        String ufname = fnameField.getText();
        String ulname = lnameField.getText();
        String uemail = emailField.getText();
        String upwd = pwdField.getText();
        String ucpwd = confirmPwdField.getText();
        if (ufname.isEmpty() || ulname.isEmpty() || uemail.isEmpty() || upwd.isEmpty() || ucpwd.isEmpty()){
            createAccntBtn.setOnAction(e->ErrClass.ErrBox("ERROR", "You left some fields blank!"));
        }
    }

    @FXML
    private void exitWindow(ActionEvent event) {
        System.exit(0);
    }
    
}
