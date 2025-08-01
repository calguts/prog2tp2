import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

/**
 * Gère l'arrière-plan.
 */

public class ScrollingBackground {
    private final Image image;
    private final double width = 640;
    private final double height = 400;

    private double scrollX = 0;

    public ScrollingBackground() {
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fichiersFH/bg.png")));
    }

    public void update(double dt, double ghostSpeed) {
        scrollX -= ghostSpeed * dt;
        if (scrollX <= -width) {
            scrollX += width;
        }
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, 0, 0, width, height, scrollX, 0, width, height);
        gc.drawImage(image, 0, 0, width, height, scrollX + width, 0, width, height);
    }
}