package gomoku;

import java.util.Scanner;

/**
 * Classe permettant au joueur de jouer
 * @author Victor Josso
 */
public class Joueur implements Players {
    
    static Scanner in = new Scanner(System.in);
    
    final Color couleur = Color.WHITE;
    
    
    /**
     * Determine en fonction du choix du joueur la pose d'un pion
     * @param platJeu, plateau sur lequel le jeu se déroule
     * @param nbTour, indique le nombre du tour
     * @return pose, case sélectionnée par le joueur
     */
    @Override
    public Case poseJeu(Plateau platJeu, int nbTour){
        
        Utils verif = new Utils();
        
        int row = 0;
        int col = 0;
        
        boolean valide = false;
        
        String ligne;
        String colonne;
        
        do {
            
            //vérification du placmeent pion ligne
            do{
                System.out.println("");
                System.out.print("Insérez la ligne où vous voulez placer votre pion :");
                ligne = in.nextLine().trim();
                
            }while(!verif.inputValidation(ligne, platJeu.getNbRows()));
            row = Integer.parseInt(ligne);
            
            //vérification du placement pion colonne
            do{
                System.out.println("");
                System.out.print("Insérez la colonne où vous voulez placer votre pion :");
                colonne = in.nextLine().trim();
                
            }while(!verif.inputValidation(colonne, platJeu.getNbCols()));
            col = Integer.parseInt(colonne);
            
            if(platJeu.getCase(row, col) == Color.NONE && verif.pionsVoisins(platJeu, new Case(row, col)) || nbTour == 1){ valide = true;} 
            else { System.out.println("-> Placement invalide"); };
        } while(!valide);
        
        Case pose = new Case(row, col);
        
        return pose;
    }
}
