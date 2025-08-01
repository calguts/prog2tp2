/**
 * Obstacle qui reste à une hauteur fixe
 */

public class ObstacleSimple  extends Obstacle {


    /**
     * Constructeur
     * @param x
     * @param y
     * @param radius
     * @param imagePath
     */
    public ObstacleSimple(double x, double y, double radius, String imagePath) {
        super(x, y, radius, imagePath);
    }


    /**
     * Pas de mouvment vertical, mais la méthode doit exister
     * @param dt
     */
    @Override
    public void updateMovement(double dt) {
        // no vertical movement
    }
}