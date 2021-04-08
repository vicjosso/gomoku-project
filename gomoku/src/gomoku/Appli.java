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
        
        Utils verif = new Utils();
        
        Case caseJeu = new Case(0, 0);
        
        int row = 0;
        int col = 0;
        
        boolean win = false;
        
        String ligne;
        String colonne;
   
        do{
            //Demande nombre de ligne avec vérification de la validité de l'indice
            System.out.println("");
            System.out.print("Veuillez entrer le nombre de ligne :"); 
            ligne = in.nextLine().trim();
            
        } while(!verif.inputValidation(ligne, 99));
        row = Integer.parseInt(ligne);
        
        if(row == 69){System.out.println("Nice");}
        
        do{
            //Demande nombre de colonne avec vérification de la validité de l'indice
            System.out.println("");
            System.out.print("Veuillez entrer le nombre de colonne :");
            colonne = in.nextLine().trim(); 
            
        } while(!verif.inputValidation(colonne, 99));
        col = Integer.parseInt(colonne);
        
        if(col == 69){System.out.println("Nice");}
        
        System.out.println("");
        System.out.println("-> Création du tableau en cours....");
        System.out.println("");
        
        Plateau platJeu = new Plateau(row, col);
        
        Joueur joueur = new Joueur();
        IA ia = new IA();
        
        platJeu.afficheTab();
        
        while(!win){
                 
            caseJeu = joueur.poseJeu(platJeu);
            platJeu.setCase(caseJeu.getRow()-1, caseJeu.getCol()-1, Color.WHITE); //verifier offset
            
            platJeu.afficheTab();
            
            //verif du plateau si victoire, implementer class game et methode check placement et check victoire
            
            ia.poseJeu(platJeu);
            platJeu.setCase(caseJeu.getRow()-1, caseJeu.getCol()-1, Color.BLACK); //verifier offset
            
            platJeu.afficheTab();
            
        }
        /*
        Plan d'action: 
            -mettre ne place la possibilité de jouer (moyen fait), condition de placement aussi
            -avancer IA pour implementer l'input de commande, en deux fois aussi 
            -faire des tests
            -implementer la victoire
            -implémenter les exceptions
            -faire la meme pour les autres modes de jeux
            -implementer des noms de bots / niveau (option)
        */
    }
}
