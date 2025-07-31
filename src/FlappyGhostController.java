import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class FlappyGhostController {

    @FXML
    public Canvas gameCanvas;  // Public or provide a getter

    @FXML
    public void initialize() {
        // Called automatically after FXML is loaded
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        gc.fillText("Canvas Ready", 100, 100);
    }

    public void onPauseButtonClick(ActionEvent actionEvent) {
    }

    public void onKeyDown(KeyEvent keyEvent) {
    }

    public void onDebugMode(ActionEvent actionEvent) {
    }



}