/**
 * Obstacle dont le mouvement vertical suit une fonction sinusoïdale.
 * Enfant d'Obstacle
 */

public class ObstacleSinus extends Obstacle {
    private double initialY;
    private double timeElapsed = 0;
    private final double amplitude = 50; // pixels
    private final double frequency = 2; // oscillations per second


    /**
     * * Crée un obstacle sinusoïdal à une position donnée.
     * @param x position horizontale
     * @param y position verticale
     * @param radius radius de l'obstacle
     * @param imagePath adresse de l'image
     */
    public ObstacleSinus(double x, double y, double radius, String imagePath) {
        super(x, y, radius, imagePath);
        this.initialY = y;
    }

    /**
     * Mouvement vertical sinusoidal
     * @param dt
     */
    @Override
    public void updateMovement(double dt) {
        timeElapsed += dt;
        yPos = initialY + amplitude * Math.sin(2 * Math.PI * frequency * timeElapsed);
    }
}
