import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FlappyGhost extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlappyGhost.class.getResource("FlappyGhost-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Flappy Ghost par Cal Gutiérrez!");
        stage.setMinHeight(440);
        stage.setMaxHeight(440);
        stage.setMinWidth(640);
        stage.setMaxWidth(640);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}