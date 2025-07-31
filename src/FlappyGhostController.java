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

    public boolean isDebugMode;
    public boolean isPaused;
    private AnimationTimer gameLoop;

    public Canvas getCanvas() {
        return gameCanvas;
    }

    @FXML
    public void initialize() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();

        isDebugMode = false;
        isPaused = false;

        gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (isPaused) {
                    lastUpdate = now; // reset lastUpdate so dt won't be huge after pause
                    return;
                }

                if (lastUpdate > 0) {
                    double dt = (now - lastUpdate) / 1e9; // convert nanoseconds to seconds
                    GameOn.updateGameState(dt);           // update your game logic with dt
                    render();                            // draw everything
                }
                lastUpdate = now;

            }
        };

        gameLoop.start();
    }

    private void render () {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());



        // Draw ghost

        if (isDebugMode) {
            //
        } else {
            //
        }

        // Draw obstacles
        for (Obstacle obs : ObstaclesListe.getMesObstacles()) {
            if (isDebugMode) {
               //
            } else {
                //
            }
        }

        // Update score label
        scoreLabel.setText(String.format("%02d", GameOn.getScore()));

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
            case SPACE:
                Ghost.setGoingUp(true);
                break;

            default:
                break;
        }
    }

    public void onKeyUp(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
            case W:
            case SPACE:
                Ghost.setGoingUp(false);
                break;
        }
    }

    public void onDebugMode(ActionEvent actionEvent) {
        isDebugMode = !isDebugMode;
    }

}