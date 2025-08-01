import java.util.Random;


/**
 * Classe abstraite représentant un obstacle générique dans le jeu.
 * Les obstacles ont une position, une taille fixe (rayon), et un comportement spécifique à leur sous-classe.
 */

public class Obstacle {

    protected double xPos;
    protected double yPos;
    protected double radius;
    protected String imagePath;

    /**
     * Constructeur pour initialiser un obstacle à une position donnée.
     * @param x Position horizontale initiale.
     * @param y Position verticale initiale.
     * @param radius Radius de l'obstacle
     * @param imagePath Adresse de l'image
     */
    public Obstacle(double x, double y, double radius, String imagePath) {
        this.xPos = x;
        this.yPos = y;
        this.radius = radius;
        this.imagePath = imagePath;
    }

    /**
     * Met à jour la position de l'objet par rapport au fantôme
     * @param dt temps depuis le dernier frame
     * @param ghostSpeed vitesse du fantôme
     */
    public void update(double dt, double ghostSpeed) {
        xPos -= ghostSpeed * dt;
    }

    /**
     * les getter de la classe
     */

    public double getX() { return xPos; }
    public double getY() { return yPos; }
    public double getRadius() { return radius; }
    public String getImagePath() { return imagePath; }

    /**
     * Met à jour la position ou l'état de l'obstacle.
     *Chaque type d'obstacle a un comportement propre.
     * @param dt
     */
    public void updateMovement(double dt) {}

    /**
     * Cette classe sers a appeler les deux classe qui
     * cont mettre a jour la postion de l'obstacle:
     * horizontalement qui est partage par tout les types d'obstacles
     * verticalement: override dans la sous-classe
     * @param dt
     * @param ghostSpeed
     */
    public void tick(double dt, double ghostSpeed) {
        update(dt, ghostSpeed);    // horizontal movement
        updateMovement(dt);        // vertical or teleport movement
    }
}
