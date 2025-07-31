import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import static com.sun.scenario.effect.impl.prism.PrEffectHelper.render;

public class FlappyGhostController {

    @FXML
    public Canvas gameCanvas;
    public Button pauseBtn;
    public CheckBox debugChbox;
    public Label scoreLabel;

    public boolean isDebugMode = false;
    public boolean isPaused = false;
    private AnimationTimer gameLoop;

    public Canvas getCanvas() {
        return gameCanvas;
    }

    @FXML
    public void initialize() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();


        gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (lastUpdate > 0) {
                    double dt = (now - lastUpdate) / 1e9;
                    GameOn.updateGameState(dt);
                    render();
                }
                lastUpdate = now;
            }
        };

        gameLoop.start();
    }

    private void render () {

    }

    public void onPauseButtonClick(ActionEvent actionEvent) {
        if (gameLoop != null) {
            if (isPaused) {
                gameLoop.start();
                isPaused = false;
                pauseBtn.setText("Pause");
            }
            else if (!isPaused) {
                gameLoop.stop();
                isPaused = true;
                pauseBtn.setText("Resume");

            }

        }
    }

    public void onKeyDown(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case ESCAPE:
                Platform.exit();
                break;

            case UP:
            case W:
                //UP
                break;

            case DOWN:
            case S:
                //DOWN
                break;

            default:
                break;
        }
    }

    public void onDebugMode(ActionEvent actionEvent) {
        isDebugMode = !isDebugMode;
    }



}