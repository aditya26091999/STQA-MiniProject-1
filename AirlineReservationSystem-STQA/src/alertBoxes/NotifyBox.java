package alertBoxes;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotifyBox {
	public static void NotificationBox(String title, String content) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Notification");
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
	}
}
