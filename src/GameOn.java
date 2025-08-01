import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Random;


public class GameOn {
    boolean isGameOver = false;
    boolean isGamePaused = false;
    int score = 0;
    int speed;
    Ghost myGhost;
    ObstaclesListe mesObstacles;
    ScrollingBackground bg;

    public GameOn() {
        myGhost = new Ghost();
        mesObstacles = new ObstaclesListe();
        mesObstacles.addObstacle();
        bg = new ScrollingBackground();
    }

    public static void gameStart() {


    }

    public void updateGameState(Double dt) {
        // Met à jour l'arrière-plan, le ghost puis les obstacles
        bg.update(dt, myGhost.getHorizontalSpeed());
        myGhost.update(dt);
        for (Obstacle obstacle : mesObstacles.getMesObstacles()) {
            obstacle.tick(dt, myGhost.getHorizontalSpeed());
        }

        // Se débarasse des obstacles sortis de l'écran et en ajoutent des nouveaux
        if (mesObstacles.getMesObstacles().get(0).getX() < 0) {
            incrementScore();
            mesObstacles.removeObstacle(0);
            mesObstacles.addObstacle();
            myGhost.obstaclePassed();
        }



        checkCollision();

    }

    public static void gameRestart() {

    }

    public void checkCollision(){
        for (Obstacle obstacle : mesObstacles.getMesObstacles()) {
            double distance = Math.sqrt(Math.pow(myGhost.getPosX() - obstacle.getX(), 2) +
                Math.pow(myGhost.getPosY() - obstacle.getY(), 2));

            if (distance <= myGhost.getRadius() + obstacle.getRadius()) {
                Platform.exit();
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

    public void incrementScore() {
        score += 5;
    }


}
