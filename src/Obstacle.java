import java.util.Random;

public class Obstacle {

    protected double xPos;
    protected double yPos;
    protected double radius;
    protected String imagePath;

    public Obstacle(double x, double y, double radius, String imagePath) {
        this.xPos = x;
        this.yPos = y;
        this.radius = radius;
        this.imagePath = imagePath;
        ObstaclesListe.addObstacle(this);
    }

    // All obstacles move left at ghost speed (simulate ghost moving right)
    public void update(double dt, double ghostSpeed) {
        xPos -= ghostSpeed * dt;
    }

    public double getX() { return xPos; }
    public double getY() { return yPos; }
    public double getRadius() { return radius; }
    public String getImagePath() { return imagePath; }

    // Abstract method to handle additional movement per obstacle type
    public void updateMovement(double dt) {}

    // Call this every frame to update position and movement
    public void tick(double dt, double ghostSpeed) {
        update(dt, ghostSpeed);    // horizontal movement
        updateMovement(dt);        // vertical or teleport movement
    }
}
