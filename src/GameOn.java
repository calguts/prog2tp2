import java.util.ArrayList;


public class GameOn {
    boolean isGameOver = false;
    boolean isGamePaused = false;
    int score = 0;
    int speed;
    static Ghost myGhost;
    ObstaclesListe mesObstacles;

    public GameOn() {
        myGhost = new Ghost();
        mesObstacles = new ObstaclesListe();
    }

    public static void gameStart() {


    }

    public static void updateGameState(Double dt) {
        myGhost.update(dt);
        checkCollision();
    }

    public static void gameRestart() {

    }

    public static void checkCollision(){
        for (Obstacle obstacle : mesObstacles.getMesObstacles()) {
            double distance = Math.sqrt(Math.pow(myGhost.getPosX() - obstacle.getX(), 2) +
                Math.pow(myGhost.getPosY() - obstacle.getY(), 2));

            if (distance <= myGhost.getRadius() + obstacle.getRadius()) {
                isGameOver = true;
            }
        }
    }

    public static void checkIfCreateObstacle(){

    }

    public  int getSpeed() {
        return speed;
    }

    public int getScore() {
        return score;
    }





}
