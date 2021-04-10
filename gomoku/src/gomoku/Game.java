package gomoku;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class Game {
    
    static Scanner in = new Scanner(System.in);
    
    
    public void afficheRegles(){
        System.out.println("Affichage des règles de jeu du gomoku :");
        System.out.println("    -les joueurs posent des pions à tour de rôle dans une case vide.");
        System.out.println("    -on doit jouer à côtés d'une case déjà occupée, sauf au premier coup.");
        System.out.println("    -le gagnant est lre premier qui aligne 5 pions selon une ligne, colonne, ou diagonale.");
        System.out.println("    -la prtie est nulle si toutes les cases sont occupées.");
        System.out.println("");
    }
    
    /**
     * Lance une partie de joueur contre une IA
     */
    public void againstIA(){
        
        Case caseJeu = new Case(0, 0);
        
        int nbTour = 1;
        
        boolean win = false;
        boolean joueurWin1 = false;
        
        ArrayList<String> pile = new ArrayList<String>();
        
        Plateau platJeu = creatBoard();
        
        Joueur joueur = new Joueur();
        IA ia = new IA();
        
        platJeu.afficheTab();
        
        while(!win){
                 
            caseJeu = joueur.poseJeu(platJeu, nbTour);
            platJeu.setCase(caseJeu.getRow(), caseJeu.getCol(), Color.WHITE);
            pile.add("Le joueur joue sur la ligne " + caseJeu.getRow() + " et sur la colonne " + caseJeu.getCol());
            
            platJeu.afficheTab();
            if(checkWin(platJeu)){joueurWin1 = true; win = true; break;}
            if(checkDraw(platJeu)){break;}
            
            caseJeu = ia.poseJeu(platJeu, nbTour);
            platJeu.setCase(caseJeu.getRow(), caseJeu.getCol(), Color.BLACK);
            pile.add("L'IA joue sur la ligne " + caseJeu.getRow() + " et sur la colonne " + caseJeu.getCol());
            
            platJeu.afficheTab();
            win = checkWin(platJeu);
            if(checkDraw(platJeu)){break;}
            
            nbTour++;
            
        }
        
        resultGame(win, joueurWin1, pile);
        
        
        /*
        Plan d'action: 
            -condition de placement aussi
            -avancer IA pour implementer l'input de commande (moyen)
            -option /quit avec exception (galere)
        */
    }
    
    
    /**
     * Lance une partie joueur contre joueur
     */
    public void againstPlayer(){
        
        Case caseJeu = new Case(0, 0);
        
        int nbTour = 1;
        
        boolean win = false;
        boolean joueurWin1 = false;
        
        ArrayList<String> pile = new ArrayList<String>();
        
        Plateau platJeu = creatBoard();
        
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        
        platJeu.afficheTab();
        
        while(!win){
                 
            caseJeu = joueur1.poseJeu(platJeu, nbTour);
            platJeu.setCase(caseJeu.getRow(), caseJeu.getCol(), Color.WHITE);
            pile.add("Le joueur joue sur la ligne " + caseJeu.getRow() + " et sur la colonne " + caseJeu.getCol());
            
            platJeu.afficheTab();
            if(checkWin(platJeu)){joueurWin1 = true; win = true; break;}
            if(checkDraw(platJeu)){break;}
            
            nbTour++; //doublon afin d'éviter la possiblité de placement libre
            
            caseJeu = joueur2.poseJeu(platJeu, nbTour);
            platJeu.setCase(caseJeu.getRow(), caseJeu.getCol(), Color.BLACK);
            pile.add("L'IA joue sur la ligne " + caseJeu.getRow() + " et sur la colonne " + caseJeu.getCol());
            
            platJeu.afficheTab();
            win = checkWin(platJeu);
            if(checkDraw(platJeu)){break;}
            
            nbTour++;
            
        }
        
        resultGame(win, joueurWin1, pile);
        
    }
    
    /**
     * Permet de créer le tableau en fonction des paramètres rentré par l'utilisateur
     * @return le tableau créer
     */
    private Plateau creatBoard(){
        
        Utils verif = new Utils();
        
        int row = 0;
        int col = 0;
        
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
        return platJeu;
    }
    
    /**
     * Vérifie si il reste de la place sur le plateau après le placement d'un pion
     * @param platJeu, plateau sur lequel se déroule la partie
     * @return true si il n'y a plus de place pour jouer 
     */
    public boolean checkDraw(Plateau platJeu){
        
        for(int i = 1; i < platJeu.getNbRows()+1; i++)
        {
            for(int j = 1; j < platJeu.getNbCols()+1; j++)
            {
                //check espace libre
                if(platJeu.getCase(i, j) == Color.NONE)
                {
                    return false;
                }
            
            }
        }
        return true;
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
        
        while(cpt < 5){
            if(col+cpt < platJeu.getNbCols()+1){
                if(platJeu.getCase(row, col+cpt) == couleur){cpt++;}
                else{cpt = 6;}
                if(cpt == 5){return true;}
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
        
        while(cpt < 5){
            if(row+cpt < platJeu.getNbRows()+1){
                if(platJeu.getCase(row+cpt, col) == couleur){cpt++;}
                else{cpt = 6;}
                if(cpt == 5){return true;}
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
        
        while(cpt1 < 5){
            if(row+cpt1 < platJeu.getNbRows()+1 && col-cpt2 > 0){ 
                if(platJeu.getCase(row+cpt1, col-cpt2) == couleur){cpt1++; cpt2++;}
                else{cpt1 = 6;}
                if(cpt1 == 5){return true;}
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
        
        while(cpt1 < 5){
            if(row+cpt1 < platJeu.getNbRows()+1 && col+cpt2 < platJeu.getNbCols()+1){
                if(platJeu.getCase(row+cpt1, col+cpt2) == couleur){cpt1++; cpt2++;}
                else{cpt1 = 6;}
                if(cpt1 == 5){return true;}
            } else {return false;}
        }
        
        return false;
    }
    
    /**
     * Affiche les résultats de la partie
     * @param win, symobolise la victoire
     * @param winJoueur1, true si c'est le joueur 1 qui a gagné, false si c'est le 2
     * @param pile, list des coups joués
     */
    public void resultGame(boolean win, boolean winJoueur1, ArrayList<String> pile){
        if(win){
            
            if(winJoueur1){ System.out.println("-> Vous avez gagnez"); } else {System.out.println("-> Victoire de l'adversaire");}
        } else {System.out.println("-> Vous avez fait une égalité");}
        
        System.out.println("Voulez-vous voir l'historique de placement des pions?(y/n) :");
            boolean loop = true;
            String commande = in.nextLine().trim();
            
            while(loop){
                switch (commande){
                    case "y":
                        for(String s : pile){System.out.println(s);}
                        System.out.println("");
                        loop = false;
                        break;
                    case "n":
                        loop = false;
                        break;
                    default:
                        System.out.println("-> Commande inconnue '" + commande + "'");
                }
            }
    }
}
