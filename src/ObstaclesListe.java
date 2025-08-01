
    import java.util.ArrayList;

    /**
     * Classe représentant la liste globale des obstacles de l'application.
     * Elle permet de centraliser et gérer les objets ajoutées ou supprimées.
     *
     */
    public class ObstaclesListe {

        private static ArrayList<Obstacle> mesObstacles = new ArrayList<>();

        /**
         * Ajoute obstacle a la liste
         * @param monObs
         */
        public static void addObstacle(Obstacle monObs) {
            mesObstacles.add(monObs);
        }

        /**
         * Retourne la liste
         * @return mesObstacles
         */
        public static ArrayList<Obstacle> getMesObstacles() {
            return mesObstacles;
        }

        /**
         * Reset la liste
         */
        public static void reset() {
            mesObstacles.clear(); // Optional reset function
        }
    }
