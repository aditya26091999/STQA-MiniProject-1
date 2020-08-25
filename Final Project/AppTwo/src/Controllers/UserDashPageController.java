package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UserDashPageController {
	@FXML
    private AnchorPane userDashBoard;

    @FXML
    private DatePicker departDate;

    @FXML
    private DatePicker arrivalDate;

    @FXML
    private TextField originCityTxtField;

    @FXML
    private TextField destTxtField;

    @FXML
    private Button searchFlightBtn;
    
    @FXML
    void SearchFlights(ActionEvent event) {

    }
}
