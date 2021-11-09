package scene;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuScene {
    private static String chosenType;

    public MenuScene() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while(true) {
                System.out.println("Bienvenue!");
                System.out.println("Pour jouer, il suffit de tapper les lettres correspondantes à un choix affiché (majuscule ou minuscule)");
                System.out.println("Le jeu possède 4 niveaux avec des monstres diffèrents, la difficulté augmente avec le niveau");
                System.out.println("Pour passer d'un niveau à un autre il suffit de vous diriger vers la case qui contient le drapeau");
                System.out.println("Conseil: Essayez de farmer les monstres à chaque niveau pour acheter de meilleures équipements " +
                        "avant de passer au prochain niveau.");
                System.out.println("Choisis ton type de personnage: ");
                System.out.println("S - Swordsman");
                System.out.println("M - Mage");

                line = in.readLine().toLowerCase();
                if (line.startsWith("s")) {
                    chosenType = "Swordsman";
                    break;
                } else if(line.startsWith("m")) {
                    chosenType = "Mage";
                    break;
                }
            }

        } catch(Exception e)  {
            e.printStackTrace();
        }
    }

    public static String getChosenType() {
        return chosenType;
    }
}
