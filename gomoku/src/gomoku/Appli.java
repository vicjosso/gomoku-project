package gomoku;

import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class Appli {
    
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
    
    /**
     * Lance une partie de joueur contre IA
     */
    public static void againstIA(){
        
        int row = 0;
        int col = 0;
        
        boolean rowOk = false;
        boolean colOk = false;
        boolean win = false;
        
        
        
        do{
            //Demande nombre de ligne avec vérification de la validité de l'indice
            System.out.println("");
            System.out.print("Veuillez entrer le nombre de ligne :");
            String ligne = in.nextLine().trim();
            try{
                row = Integer.parseInt(ligne);
                if(row < 0 || row > 99){ System.out.println("Indice invalide");}
                else { rowOk = true; }
            } catch (Exception e){
                System.out.println("Tu n'as pas rentré un nombre");
            }
        } while(!rowOk);
        
        if(row == 69){System.out.println("Nice");}
        
        do{
            //Demande nombre de colonne avec vérification de la validité de l'indice
            System.out.println("");
            System.out.print("Veuillez entrer le nombre de colonne :");
            String colonne = in.nextLine().trim();

            try{
                col = Integer.parseInt(colonne);
                if(col < 0 || col > 99){ System.out.println("Indice invalide");}
                else { colOk = true; }
            } catch (Exception e){
                System.out.println("Tu n'as pas rentré un nombre");
            }
        } while(!colOk);
        
        if(col == 69){System.out.println("Nice");}
        
        System.out.println("");
        System.out.println("-> Création du tableau en cours....");
        System.out.println("");
        
        Plateau platJeu = new Plateau(row, col);
        
        Joueur joueur = new Joueur();
        IA ia = new IA();
        
        platJeu.afficheTab();
        
        while(!win){
                 
            joueur.poseJeu(platJeu);
            
            platJeu.afficheTab();
            
            ia.poseJeu(platJeu);
            
            platJeu.afficheTab();
            
        }
        /*
        Plan d'action: 
            -mettre ne place la possibilité de jouer
            -avancer joueur et IA pour implementer l'input de commande, en deux fois aussi 
            -faire des tests
            -afficher le tableau et l'update a chaque tour, implementer la victoire, condition de placement aussi
            -ajoute le tableau en param/attribut du joueur pour verifier la possibilité de placement
            -faire la meme pour les autres modes de jeux
            -implementer des noms de bots / niveau
            -implémenter les exceptions
        */
    }
}
