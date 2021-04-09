package gomoku;

import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class Game {
    
    static Scanner in = new Scanner(System.in);
    
    /**
     * Lance une partie de joueur contre une IA
     */
    public void againstIA(){
        
        Utils verif = new Utils();
        
        Case caseJeu = new Case(0, 0);
        
        int row = 0;
        int col = 0;
        
        boolean win = false;
        boolean joueurWin = false;
        
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
            platJeu.setCase(caseJeu.getRow(), caseJeu.getCol(), Color.WHITE); //verifier offset
            
            
            platJeu.afficheTab();
            if(checkWin(platJeu)){joueurWin = true; break;}
            
            //verif du plateau si victoire, implementer class game et methode check placement et check victoire
            
            caseJeu = ia.poseJeu(platJeu);
            platJeu.setCase(caseJeu.getRow(), caseJeu.getCol(), Color.BLACK); //verifier offset
            
            platJeu.afficheTab();
            win = checkWin(platJeu);
            
        }
        
        if(win){
            if(joueurWin){ System.out.println("-> Vous avez gagnez"); } else {System.out.println("-> Victoire de l'IA");}
        }
        /*
        Plan d'action: 
            -condition de placement aussi
            -avancer IA pour implementer l'input de commande (moyen)
            -faire des tests
            -implementer la victoire
            -implémenter les exceptions
            -faire la meme pour les autres modes de jeux
            -implementer des noms de bots / niveau (option)
        */
    }
    
    
    private boolean checkWin(Plateau platJeu){
        boolean win = false;
        
        for(int i = 0; i < platJeu.getNbRows(); i++)
        {
            for(int j = 0; j < platJeu.getNbCols(); j++)
            {
                if(platJeu.getCase(i, j) == Color.WHITE){} //check du placement des pions
                if(platJeu.getCase(i, j) == Color.BLACK){}
            }
        }
        
        return win;
    }
}
