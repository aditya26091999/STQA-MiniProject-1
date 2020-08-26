package Controllers;
import java.time.format.DateTimeFormatter;

import alertBoxes.ErrClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UserDashboardFXMLController {
	@FXML
    private TextField sourceTxtField;

    @FXML
    private TextField destTxtField;

    @FXML
    private DatePicker departDate;

    @FXML
    private Button SearchFlightBtn;

    @FXML
    void SearchFlights(ActionEvent event) {
    	try {
    		String source = sourceTxtField.getText();
        	String dest = destTxtField.getText();
        	String dateDepart = "";
        	String dateArriv = "";
        	dateDepart = departDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
        	
        	if(source.isEmpty() || dest.isEmpty()) {
        		ErrClass.ErrBox("Missing Fields", "You left some fields Blank!");
        	}
    	}catch(NullPointerException e) {
    		System.out.println("Date field not entered!");
    		ErrClass.ErrBox("Error", "Missing Date fields");
    	}
    	
    }
}
