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
        Joueur joueur2 = new Joueur();
        IA ia = new IA();
        
        platJeu.afficheTab();
        
        while(!win){
                 
            caseJeu = joueur.poseJeu(platJeu);
            platJeu.setCase(caseJeu.getRow(), caseJeu.getCol(), Color.WHITE); 
            
            
            platJeu.afficheTab();
            if(checkWin(platJeu)){joueurWin = true; break;}
            
            //verif du plateau si victoire, implementer class game et methode check placement et check victoire
            
            //caseJeu = ia.poseJeu(platJeu);
            caseJeu = joueur2.poseJeu(platJeu);
            platJeu.setCase(caseJeu.getRow(), caseJeu.getCol(), Color.BLACK);
            
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
            -implementer la victoire //non fonctionnel
            -implémenter les exceptions
            -faire la meme pour les autres modes de jeux
            -implementer des noms de bots / niveau (option)
        */
    }
    
    /**
     * Vérifie si une des combinaisons sur le plateau rapporte la victoire
     * @param platJeu, plateau sur lequel se déroule le jeu
     * @return true si une combinaison est juste, sinon false
     */
    public boolean checkWin(Plateau platJeu){
        
        for(int i = 1; i < platJeu.getNbRows()+1; i++)
        {
            for(int j = 1; j < platJeu.getNbCols()+1; j++)
            {
                //check placement pions blanc
                if(platJeu.getCase(i, j) == Color.WHITE)
                {
                    if(checkAll(i, j, Color.WHITE, platJeu)){return true;}
                }
                //check du placement pions noirs
                if(platJeu.getCase(i, j) == Color.BLACK)
                {
                    if(checkAll(i, j, Color.BLACK, platJeu)){return true;}
                }
            
            }
        }
        
        return false;
    }
    
    /**
     * Vérifie toutes les combinaisons de placement pour une case donnée
     * @param row, numéro de la ligne
     * @param col, numéro de la colonne
     * @param couleur, couleur de la case qui nous intéresse
     * @param platJeu, plateau sur lequel se déroule le jeu
     * @return true si une des combinaisons est juste, sinon false
     */
    private boolean checkAll(int row, int col, Color couleur, Plateau platJeu){
        
        if(checkLine(row, col, couleur, platJeu)){return true;}
        if(checkCol(row, col, couleur, platJeu)){return true;}
        if(checkDiagLeft(row, col, couleur, platJeu)){return true;}
        if(checkDiagRight(row, col, couleur, platJeu)){return true;}
        
        return false;
    }
    
    /**
     * Vérifie la combinaison sur une ligne
     * @param row, numéro de la ligne
     * @param col, numéro de la colonne
     * @param couleur, couleur de la case qui nous intéresse
     * @param platJeu, plateau sur lequel se déroule le jeu
     * @return true si la combinaison est juste, sinon false
     */
    private boolean checkLine(int row, int col, Color couleur, Plateau platJeu){
        int cpt = 1;
        
        while(cpt < 4){
            if(col+cpt < platJeu.getNbCols()+1){
                if(platJeu.getCase(row, col+cpt) == couleur){cpt++;}
                else{cpt = 6;}
                if(cpt == 4){return true;}
            } else { return false;}
        }
        
        return false;
    }
    
    /**
     * Vérifie la combinaison sur une colonne
     * @param row, numéro de ligne
     * @param col, numéro de colonne
     * @param couleur, couleur de la case qui nous intéresse
     * @param platJeu, plateau sur lequel se déroule le jeu
     * @return true si la combinaison est juste, sinon false
     */
    private boolean checkCol(int row, int col, Color couleur, Plateau platJeu){
        int cpt = 1;
        
        while(cpt < 4){
            if(row+cpt < platJeu.getNbRows()+1){
                if(platJeu.getCase(row+cpt, col) == couleur){cpt++;}
                else{cpt = 6;}
                if(cpt == 4){return true;}
            } else {return false;}
        }
        
        return false;
    }
    
    /**
     * Vérifie la combinaison sur la diagonale basse gauche
     * @param row, numéro de la ligne
     * @param col, numéro de la colonne
     * @param couleur, couleur de la case qui nous intéresse
     * @param platJeu, plateau sur leqeul se déroule le jeu
     * @return true si la combinaison est juste, sinon false
     */
    private boolean checkDiagLeft(int row, int col, Color couleur, Plateau platJeu){
        int cpt1 = 1;
        int cpt2 = 1;
        
        while(cpt1 < 4){
            if(row+cpt1 < platJeu.getNbRows()+1 && col-cpt2 < platJeu.getNbCols()+1){
                if(platJeu.getCase(row+cpt1, col-cpt2) == couleur){cpt1++; cpt2++;}
                else{cpt1 = 6;}
                if(cpt1 == 4){return true;}
            } else {return false;}
        }
        
        return false;
    }
    
    /**
     * Vérifie la combinaison sur la diagonale basse droite
     * @param row, numéro de la ligne
     * @param col, numéro de la colonne
     * @param couleur, couleur de la case qui nous intéresse
     * @param platJeu, plateau sur lequel e déroule le jeu
     * @return true si la combinaison est jsute, sinon false
     */
    private boolean checkDiagRight(int row, int col, Color couleur, Plateau platJeu){
        int cpt1 = 1;
        int cpt2 = 1;
        
        while(cpt1 < 4){
            if(row+cpt1 < platJeu.getNbRows()+1 && col+cpt2 < platJeu.getNbCols()+1){
                if(platJeu.getCase(row+cpt1, col+cpt2) == couleur){cpt1++; cpt2++;}
                else{cpt1 = 6;}
                if(cpt1 == 4){return true;}
            } else {return false;}
        }
        
        return false;
    }
    
}
