import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FlappyGhostController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public static class Ghost {
    }

    public static class ObstacleQuantique {
    }
}