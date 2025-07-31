public class ObstacleSimple  extends Obstacle {
    public ObstacleSimple(double x, double y, double radius, String imagePath) {
        super(x, y, radius, imagePath);
    }

    // No vertical movement for simple obstacles
    @Override
    public void updateMovement(double dt) {
        // no vertical movement
    }
}