import java.util.Random;

/**
 * Obstacle se téléportant aléatoirement
 */
public class ObstacleQuantique extends Obstacle {
    private double lastTeleportTime = 0;
    private final double teleportInterval = 0.2; // seconds
    private final Random random = new Random();

    /**
     * Constructeur
     * @param x
     * @param y
     * @param radius
     * @param imagePath
     */
    public ObstacleQuantique(double x, double y, double radius, String imagePath) {
        super(x, y, radius, imagePath);
    }

    /**
     * Teleportation
     * @param dt
     */
    @Override
    public void updateMovement(double dt) {
        lastTeleportTime += dt;
        if (lastTeleportTime >= teleportInterval) {
            lastTeleportTime = 0;

            xPos += (random.nextDouble() * 60) - 30;
            yPos += (random.nextDouble() * 60) - 30;
        }
    }
}
