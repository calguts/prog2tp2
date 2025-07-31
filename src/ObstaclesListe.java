
    import java.util.ArrayList;

    /**
     * Classe représentant la liste globale des obstacles de l'application.
     * Elle permet de centraliser et gérer lesobjets } ajoutées ou supprimées.
     *
     */
    public class ObstaclesListe {


        public ArrayList<Obstacle> mesObstacles;

        public ObstaclesListe() {
            mesObstacles = new ArrayList<>();
        }

        public ArrayList<Obstacle> getObstaclesListe() {
            return mesObstacles;
        }

        public  void addObstacle(Obstacle monObs) {
            if (monObs != null) {
                mesObstacles.add(monObs);
            }
        }

        public void deleteObstacle(Obstacle monObs) {
            mesObstacles.remove(monObs);
        }

        public  void clearObstacles() {
            mesObstacles.clear();
        }

        public int getObstacleCount() {
            return mesObstacles.size();
        }

        public static ArrayList<Obstacle> getMesObstacles() {
            return (static)mesObstacles;
        }
    }
