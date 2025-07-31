public class ObstacleSinus extends Obstacle {
    private double initialY;
    private double timeElapsed = 0;
    private final double amplitude = 50; // pixels
    private final double frequency = 2; // oscillations per second

    public ObstacleSinus(double x, double y, double radius, String imagePath) {
        super(x, y, radius, imagePath);
        this.initialY = y;
    }

    @Override
    public void updateMovement(double dt) {
        timeElapsed += dt;
        yPos = initialY + amplitude * Math.sin(2 * Math.PI * frequency * timeElapsed);
    }
}
