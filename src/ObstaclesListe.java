
    import java.util.ArrayList;
    import java.util.Random;

    /**
     * Classe représentant la liste globale des obstacles de l'application.
     * Elle permet de centraliser et gérer les objets ajoutées ou supprimées.
     *
     */
    public class ObstaclesListe {

        private ArrayList<Obstacle> mesObstacles = new ArrayList<>();

        public void addObstacle() {
            double type = new Random().nextDouble();
            if (type < 1.0/3) {
                mesObstacles.add(new ObstacleSimple(640, 10 + (new Random().nextDouble()) * 300, 20, "/fichiersFH/obstacles/" +
                new Random().nextInt(27) + ".png"));
            } else if (type < 2.0/3) {
                mesObstacles.add(new ObstacleSinus(640, 10 + (new Random().nextDouble()) * 300, 20, "/fichiersFH/obstacles/" +
                new Random().nextInt(27) + ".png"));
            } else {
                mesObstacles.add(new ObstacleQuantique(640, 10 + (new Random().nextDouble()) * 300, 20, "/fichiersFH/obstacles/" +
                new Random().nextInt(27) + ".png"));
            }
        }

        public void removeObstacle(int index) {
            mesObstacles.remove(index);
        }

        public ArrayList<Obstacle> getMesObstacles() {
            return mesObstacles;
        }

        public void reset() {
            mesObstacles.clear(); // Optional reset function
        }
    }
