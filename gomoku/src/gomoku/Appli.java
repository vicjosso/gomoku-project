package gomoku;

import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class Appli {
    
    static Scanner in = new Scanner(System.in);
    
    static void menu(){
        boolean loop = true;
        
        while(loop){
            System.out.println("0) Quitter");
            System.out.println("1) Lancer une partie contre une IA");
            System.out.println("2) Lancer une partie contre un Joueur");
            System.out.println("3) Lancer une partie custom");
            String commande = in.nextLine().trim();
            switch (commande) {
                case "0":
                    System.out.println("-> Bye.");
                    loop = false;
                    break;
                case "1":
                    System.out.println("-> Lancement du mode de jeu contre une IA....");
                    againstIA();
                    break;
                case "2":
                    System.out.println("-> Fonctionnalité non-implémanté");
                    break;
                case "3":
                    System.out.println("-> Fonctionnalité non-implémanté");
                    
                    break;
                case "69":
                    System.out.println("UWU ceci est une fonctionnalité secrète UWU");
                    break;
                default:
                    System.out.println("-> commande inconnue '" + commande + "'");
            }
        }
    }
    
    public static void againstIA(){
        System.out.println("");
        System.out.print("Veuillez entrer le nombre de ligne :");
        String row = in.nextLine().trim();
        
        /*
        Plan d'action:
            -demander les lignes et les colonnes, en faisant gaffe soit en utilisant un int soit string a convertir, message d'erreur quand input faux
            -construire le tableau 
            -avancer joueur et IA pour implementer l'input de commande, en deux fois aussi
            -faire des tests
            -afficher le tableau et l'update a chaque tour, implementer la victoire, condition de placement aussi
            -ajoute le tableau en param/attribut du joueur pour verifier la possibilité de placement
            -faire la meme pour les autres modes de jeux
            -implementer des noms de bots / niveau
        */
    }
}
