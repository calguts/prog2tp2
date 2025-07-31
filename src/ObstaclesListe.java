
    import java.util.ArrayList;

    /**
     * Classe représentant la liste globale des cours de l'application.
     * Elle permet de centraliser et gérer lesobjets } ajoutées ou supprimées.
     *
     */
    public class ObstaclesListe {
        static ArrayList<Obstacle> mesObstacles = new ArrayList<>();

        /** Constructeur privé pour empêcher l'instanciation externe. */
        public ObstaclesListe() {

        }


        public static ArrayList<Obstacle> getObstaclesListe() {
            return mesObstacles;
        }


        public static void addObstacle(Obstacle monObs) {
            mesObstacles.add(monObs);
        }


        public static void deleteObstacle(Obstacle monObs) {
            mesObstacles.remove(monObs);
        }


}
