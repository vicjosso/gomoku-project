package gomoku;

import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class Appli {
    
    static Game game = new Game();
    
    static Scanner in = new Scanner(System.in);
    
    /**
     * Affiche le menu de jeu et permet de lancer une partie
     */
    static void menu(){
        boolean loop = true;
        
        while(loop){
            System.out.println("0) Quitter");
            System.out.println("1) Lancer une partie contre une IA");
            System.out.println("2) Lancer une partie contre un Joueur");
            System.out.println("3) Voir les règles");
            String commande = in.nextLine().trim();
            switch (commande) {
                case "0":
                    System.out.println("-> Bye.");
                    loop = false;
                    break;
                case "1":
                    System.out.println("-> Lancement du mode de jeu contre une IA....");
                    game.againstIA();
                    break;
                case "2":
                    System.out.println("-> Lancment du mode de jeu contre un Joueur....");
                    game.againstPlayer();
                    break;
                case "3":
                    game.afficheRegles();
                    break;
                case "69":
                    System.out.println("Nice");
                    break;
                default:
                    System.out.println("-> Commande inconnue '" + commande + "'");
            }
        }
    }
    
    
}
