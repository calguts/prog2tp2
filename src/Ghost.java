import javafx.scene.image.Image;

import java.util.Objects;

public class Ghost {

    private static final double INITIAL_HORIZONTAL_SPEED = 120;
    private static final double INITIAL_GRAVITY = 500;
    private static final double GRAVITY_INCREMENT = 15;
    private static final double SPEED_INCREMENT = 15;
    private static final double MAX_VERTICAL_SPEED = 300;
    private static final double JUMP_SPEED = -300;

    private double horizontalSpeed = INITIAL_HORIZONTAL_SPEED;
    private double gravity = INITIAL_GRAVITY;
    private double verticalSpeed = 0;

    private double posX;
    private double posY;
    private static final double RADIUS = 30.0;
    private int obstaclesPassed = 0;
    private boolean goingUp = false;

    private final Image image = new Image(Objects.requireNonNull(
            getClass().getResourceAsStream("/fichiersFH/ghost.png")
    ));

    public Ghost() {
        this.posX = 640.0 / 2 - image.getWidth() / 2;
        this.posY = 400.0 / 2 - image.getHeight() / 2;
    }

    public void update(double dt) {
        if (goingUp) {
            verticalSpeed = JUMP_SPEED;
        } else {
            verticalSpeed += gravity * dt;

            if (verticalSpeed > MAX_VERTICAL_SPEED) {
                verticalSpeed = MAX_VERTICAL_SPEED;
            }
        }

        if (verticalSpeed < -MAX_VERTICAL_SPEED) {
            verticalSpeed = -MAX_VERTICAL_SPEED;
        }

        posY += verticalSpeed * dt;


        if (posY <= 0) {
            posY = 0;
            verticalSpeed = Math.abs(verticalSpeed);
        }

        // Bounce off the bottom
        else if (posY >= 400 - image.getHeight()) {
            posY = 400 - image.getHeight();
            verticalSpeed = -Math.abs(verticalSpeed);
        }

    }

    public void obstaclePassed() {
        obstaclesPassed++;
        if (obstaclesPassed % 2 == 0) {
            horizontalSpeed += SPEED_INCREMENT;
            gravity += GRAVITY_INCREMENT;
        }
    }

    public static void setGoingUp(boolean goingUp) {
        goingUp = goingUp;
    }

    public boolean isGoingUp() {
        return goingUp;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public Image getImage() {
        return image;
    }

    public double getRadius() {
        return RADIUS;
    }

    public double getHorizontalSpeed() {
        return horizontalSpeed;
    }
}

