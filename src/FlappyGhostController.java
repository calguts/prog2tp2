import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.Objects;

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

    Image imageGhost = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fichiersFH/ghost.png")));

    GameOn partie = new GameOn();


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
                    partie.updateGameState(dt);           // update your game logic with dt
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


        //Dessine l'arrière-plan, le ghost, puis l'obstacle
        partie.bg.draw(gc);
        gc.drawImage(imageGhost, partie.myGhost.getPosX(), partie.myGhost.getPosY());

        for (Obstacle obstacle : partie.mesObstacles.getMesObstacles()) {
            Image imageObstacle = new Image(Objects.requireNonNull(getClass().getResourceAsStream(obstacle.getImagePath())));
            gc.drawImage(imageObstacle, obstacle.getX(), obstacle.getY());
        }

        //scoreLabel


        if (isDebugMode) {
            //
        } else {
            //
        }

        for (Obstacle obs : partie.mesObstacles.getMesObstacles()) {
            if (isDebugMode) {
               //
            } else {
                //
            }
        }

        scoreLabel.setText(String.format("%02d", partie.getScore()));

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

            case A, S, D, F, H, J, K, L:
                partie.myGhost.jump();
                break;
            case SPACE:
                partie.myGhost.jump();
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
        }
    }

    public void onDebugMode(ActionEvent actionEvent) {
        isDebugMode = !isDebugMode;
    }

}