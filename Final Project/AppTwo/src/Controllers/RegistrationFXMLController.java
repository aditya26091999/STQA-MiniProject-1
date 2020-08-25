/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import alertBoxes.ErrClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    //kawale added this
    private void clearFields() {
        fnameField.clear();
        lnameField.clear();
        emailField.clear();
        pwdField.clear();
        confirmPwdField.clear();
    }
    
    @FXML   //this method will be called when user clicks the 'CREATE ACCOUNT' button
    private void createAcnt(ActionEvent event) {
        String ufname = fnameField.getText();
        String ulname = lnameField.getText();
        String uemail = emailField.getText();
        String upwd = pwdField.getText();
        String ucpwd = confirmPwdField.getText();
        if (ufname.isEmpty() || ulname.isEmpty() || uemail.isEmpty() || upwd.isEmpty() || ucpwd.isEmpty()){
        	
        	//give error pop-up
        	ErrClass.ErrBox("Error","Fields are empty!");
            
        }
        else if (!upwd.equals(ucpwd)) {
        	
        	//clear the confirm-password field
        	// give error pop-up
        	confirmPwdField.clear();
        	ErrClass.ErrBox("Error","Passwords don't match!");  	
        }
        else {
        	// code to get authenticate the customer from db
        	String url = "jdbc:sqlite:F:/000-CollegePracticals/STQA-MiniProject-1/Final Project/Database/airline.db";
        	try{
        		
        		//using the sqlite driver in the class-path
        		Class.forName("org.sqlite.JDBC");
        		
        		//Connection object to connect to embedded db
        		Connection conn = DriverManager.getConnection(url);
        		
        		
        		//Creating a statement object to hold query
        		String add_customer = "insert into customer(fname,lname,email,password) values(?,?,?,?);";
        		
        		PreparedStatement stmt = conn.prepareStatement(add_customer);
        		stmt.setString(1,ufname);
        		stmt.setString(2,ulname);
        		stmt.setString(3,uemail);
        		stmt.setString(4,upwd);
        		stmt.executeUpdate();
        		
        		//logic to show successful registration
        		// create a pop-up that assures customer that
        		// he is registered on system and redirect him
        		// to the login page.
        		System.out.println("Added User!");
        		
        		
        	}catch(Exception e){
        		// logic to show error while filling data to db
        		// show error pop-up and clear the values of form
        		System.out.println("Error" + e);
        	}
        	
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
