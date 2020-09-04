/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import alertBoxes.ErrClass;
import alertBoxes.NotifyBox;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import AppPack.MainClass;
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
    private void adminLogin(ActionEvent event) throws IOException {

        String admineml = adminEmail.getText();
        String admpwd = adminPass.getText();
        int flag = 0;
        if(admineml.isEmpty() || admpwd.isEmpty()){
        	ErrClass.ErrBox("Empty Fields", "You left some fields empty!");
        }
        /**
         * ADDED ELSE BLOCK TO VALIDATE ADMIN CREDENTIALS 
         */
        else {
        	String sql = "SELECT email, password FROM admin";
        	try {
    			Statement stmt = MainClass.dbConnection().createStatement();
    			ResultSet rs = stmt.executeQuery(sql);
    			while(rs.next()) {
    				String email = rs.getString("email");
    				String pwd = rs.getString("password");
    				//String fname = rs.getString("fname");
    				if(email.equals(admineml) && pwd.equals(admpwd)) {
    					NotifyBox.NotificationBox("Login Successful", "Welcome Admin");
    					flag = 1;
    					break;
    				}
    			}
    			if(flag==0) {
    				ErrClass.ErrBox("Error", "Incorrect Credentials");
    			}
    			else if(flag == 1) {
    				//ADMIN DASHBOARD CODE GOES HERE
    				Parent root = FXMLLoader.load(getClass().getResource("/FXMLpack/AdminDashboardFXML.fxml")); //load the AdminDash FXML file for view
                    Stage stage = (Stage)adminLogBtn.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        
    }

    @FXML   ///this is the method that'll be called when user presses login button on the USER side
    private void userLogin(ActionEvent event) throws Exception{
        String usereml = userEmail.getText();
        String userpwd = userPass.getText();
        //System.out.println("User email: "+usereml+" User password: "+userpwd);
        if(usereml.isEmpty() || userpwd.isEmpty()){
        	ErrClass.ErrBox("Empty Fields", "You left some fields empty!");
        }
        /**
         * Ive created this else block to test the userDashboard screen. You have to fetch data from the sqlite
         * and compare it with the login info entered. this was done just for test. if you want to have a look 
         * then try entering anything and you'll be directed to the user dashboard screen.
         */
        else {
        	
          	try {
            	String searchCustomer = "select fname,lname from customer where email=? and password=?";
            	PreparedStatement stmt = MainClass.dbConnection().prepareStatement(searchCustomer);
            	stmt.setString(1, usereml);
            	stmt.setString(2, userpwd);
            	ResultSet rs = stmt.executeQuery();
            	
            	if (rs.next()!=false) {
            	
            	NotifyBox.NotificationBox("Successful-Login", "Welcome User,You are valuable to us!");
          		Parent root = FXMLLoader.load(getClass().getResource("/FXMLpack/UserDashboardFXML.fxml")); //load the registration page FXML file for view
                Stage stage = (Stage)userLogBtn.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            	}
            	else {
            		ErrClass.ErrBox("Login-Error", "Wrong Credentials");
            	}
            } catch (IOException ex) {
                Logger.getLogger(AppTwoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML   //this method will be called when user presses the CREATE ACCOUNT button on the USER side.
    private void createAccn(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLpack/RegistrationFXML.fxml")); //load the registration page FXML file for view
            Stage stage = (Stage)userPass.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AppTwoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
