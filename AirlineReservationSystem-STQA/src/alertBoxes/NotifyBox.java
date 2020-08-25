package alertBoxes;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotifyBox {
	public static void NotificationBox(String title, String content) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
        alert.setHeaderText("REGISTERED");
        alert.setContentText(content);
        alert.showAndWait();
	}
}
