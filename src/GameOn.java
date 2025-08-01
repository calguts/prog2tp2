import java.util.ArrayList;


public class GameOn {
    static boolean isGameOver = false;
    boolean isGamePaused = false;
    int score = 0;
    int speed;
    Ghost myGhost;
    ObstaclesListe mesObstacles;
    ScrollingBackground bg;

    public GameOn() {
        myGhost = new Ghost();
        mesObstacles = new ObstaclesListe();
        bg = new ScrollingBackground();
    }

    public static void gameStart() {


    }

    public void updateGameState(Double dt) {
        myGhost.update(dt);
        bg.update(dt, myGhost.getHorizontalSpeed());
        checkCollision();
    }

    public static void gameRestart() {

    }

    public void checkCollision(){
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
