import javafx.scene.image.Image;

import java.util.Objects;


/**
 * Classe qui gere le fantôme
 */

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

    private final Image image = new Image(Objects.requireNonNull(
            getClass().getResourceAsStream("/fichiersFH/ghost.png")
    ));

    /**
     * Classe constructeur
     */

    public Ghost() {
        this.posX = 640.0 / 2 - image.getWidth() / 2;
        this.posY = 400.0 / 2 - image.getHeight() / 2;
    }

    /**
     * Met a jour la position verticale du fantôme
     * @param dt
     */
    public void update(double dt) {
        verticalSpeed += gravity * dt;

        if (verticalSpeed > MAX_VERTICAL_SPEED) {
            verticalSpeed = MAX_VERTICAL_SPEED;
        }

        if (verticalSpeed < -MAX_VERTICAL_SPEED) {
            verticalSpeed = -MAX_VERTICAL_SPEED;
        }

        posY += verticalSpeed * dt;


        if (posY <= 0) {
            posY = 0;
            verticalSpeed = Math.abs(verticalSpeed);
        }

        // Rebondit du bas
        else if (posY >= 400 - image.getHeight()) {
            posY = 400 - image.getHeight();
            verticalSpeed = -Math.abs(verticalSpeed);
        }

    }

    /**
     * Augmente sa vitesse et sa gravité
     */

    public void obstaclePassed() {
        obstaclesPassed++;
        if (obstaclesPassed % 2 == 0) {
            horizontalSpeed += SPEED_INCREMENT;
            gravity += GRAVITY_INCREMENT;
        }
    }

    /**
     * Fait sauter le fantôme
     */
    public  void jump() {
        verticalSpeed = JUMP_SPEED;
    }

    /**
     * devrait rester fixe
     * @return posX
     */
    public double getPosX() {
        return posX;
    }

    /**
     * @return posY
     */
    public double getPosY() {
        return posY;
    }

    /**
     * @return Image
     */
    public Image getImage() {
        return image;
    }


    /**
     * @return radius
     */
    public double getRadius() {
        return RADIUS;
    }

    /**
     * @return horizontalSpeed
     */
    public double getHorizontalSpeed() {
        return horizontalSpeed;
    }
}

