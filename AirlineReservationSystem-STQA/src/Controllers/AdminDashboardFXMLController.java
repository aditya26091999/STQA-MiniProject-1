package Controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import alertBoxes.NotifyBox;
import javafx.event.ActionEvent;

public class AdminDashboardFXMLController {
	@FXML
    private Button adminCtrBtn;

    @FXML
    private Button adminFlightBtn;

    @FXML
    private Button adminViewClientBtn;
    
    @FXML
    void AdminEdit(ActionEvent event) {
    	NotifyBox.NotificationBox("WIP", "WORK IN PROGRESS");
    }

    @FXML
    void FlightEdit(ActionEvent event) {
    	NotifyBox.NotificationBox("WIP", "WORK IN PROGRESS");
    }

    @FXML
    void ViewClient(ActionEvent event) {
    	NotifyBox.NotificationBox("WIP", "WORK IN PROGRESS");
    }
}
