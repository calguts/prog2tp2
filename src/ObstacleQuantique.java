import java.util.Random;

public class ObstacleQuantique extends Obstacle {
    private double lastTeleportTime = 0;
    private final double teleportInterval = 0.2; // seconds
    private final Random random = new Random();

    public ObstacleQuantique(double x, double y, double radius, String imagePath) {
        super(x, y, radius, imagePath);
    }

    @Override
    public void updateMovement(double dt) {
        lastTeleportTime += dt;
        if (lastTeleportTime >= teleportInterval) {
            lastTeleportTime = 0;
            // Teleport randomly between -30 and 30 in both x and y
            xPos += (random.nextDouble() * 60) - 30;
            yPos += (random.nextDouble() * 60) - 30;
        }
    }
}
