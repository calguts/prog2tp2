
    import java.util.ArrayList;

    /**
     * Classe représentant la liste globale des obstacles de l'application.
     * Elle permet de centraliser et gérer lesobjets ajoutées ou supprimées.
     *
     */
    public class ObstaclesListe {

        private static ArrayList<Obstacle> mesObstacles = new ArrayList<>();

        public static void addObstacle(Obstacle monObs) {
            mesObstacles.add(monObs);
        }

        public static ArrayList<Obstacle> getMesObstacles() {
            return mesObstacles;
        }

        public static void reset() {
            mesObstacles.clear(); // Optional reset function
        }
    }
