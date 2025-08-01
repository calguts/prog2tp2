import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


/**
 * FlappyGhost.java par Cal Gutierrez et Thomas Ring
 * Programmation 2
 * 31 juillet 2025
 * Le joueur incarne un fantôme qui se promène dans un niveau rempli d’obstacles. Il n’y a
 * pas d’objectif autre que d’avancer le plus longtemps possible dans le niveau sans toucher
 * d’obstacle.
 */

public class FlappyGhost extends Application {

    /**
     * Launch l'appli
     * @param stage
     * @throws IOException
     */

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlappyGhost.class.getResource("FlappyGhost-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Flappy Ghost par Cal Gutiérrez et Thomas Ring!");

        int sWidth = 640;
        int sHeight = 470;
        stage.setMinHeight(sHeight);
        stage.setMaxHeight(sHeight);
        stage.setMinWidth(sWidth);
        stage.setMaxWidth(sWidth);
        stage.setScene(scene);
        stage.show();

        /* On a besoin du canvas pour lui donner le focus */
        FlappyGhostController controller = fxmlLoader.getController();
        Image imageBg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fichiersFH/bg.png")));
        int cHeight = 400;
        Canvas myCanvas =  controller.getCanvas();
        GraphicsContext gc = myCanvas.getGraphicsContext2D();

        gc.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        gc.drawImage(imageBg,  0, 0,  sWidth, cHeight, 0, 0,sWidth, cHeight);

        Image imageGhost = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fichiersFH/ghost.png")));
        double ghostWidth = (double) sWidth /2 - imageGhost.getWidth()/2;
        double ghostHeigth = (double) cHeight /2 - imageGhost.getHeight()/2;
        gc.drawImage(imageGhost, ghostWidth, ghostHeigth);

        /* Après l’exécution de la fonction, le focus va automatiquement au canvas */
        Platform.runLater(myCanvas::requestFocus);

        /* Lorsqu’on clique ailleurs sur la scène, le focus retourne sur le canvas */
        scene.setOnMouseClicked((event) -> {
            myCanvas.requestFocus();
        });

        // Met le fantôme comme icône de barre de tâches
        stage.getIcons().add(imageGhost);

    }
    /**
     * Main: fait juste lanccer l'appli javafx
     * @param args  Imput du joueur
     */
    public static void main(String[] args) {
        launch();
    }
}