package gomoku;

import java.util.ArrayList;

/**
 * Class plateau, regroupant l'ensemble des cases, du nombre de lignes et de colonnes
 * 
 * @author Victor Josso
 */
public class Plateau {
    
    final private int rowNb;
    final private int colNb;
    
    private Color turn;
    
    private Case[][] plateau;
    
    /**
     * Constructeur de la classe Plateau
     * @param row, nombre totale de ligne
     * @param col, nombre totale de colonne
     */
    public Plateau(int row, int col){
        this.rowNb = row;
        this.colNb = col;
        this.plateau = new Case[rowNb][colNb];
        
        for(int i = 0 ; i < this.rowNb ; i++){
            for(int j = 0 ; j < this.colNb ; j++){
                this.plateau[i][j] = new Case(i, j);
            }
        }
    }
    
    /**
     * Retourne le nombre de la ligne
     * @return le nombre de ligne du tableau
     */
    public int getNbRows(){
        return this.rowNb;
    }
    
    /**
     * Retourne le nombre de la colonne
     * @return le nombre de colonne du tableau
     */
    public int getNbCols(){
        return this.colNb;
    }
     
    /**
     * Retourne la case en fonction de sa ligne et sa colonne
     * @param row, ligne de la case
     * @param col, colonne de la case
     * @return la case demander
     */
    public Color getCase(int row, int col){
        return this.plateau[row][col].getColor();
    }
            
    /**
     * Initialise la couleur d'une case
     * @param row, ligne de la case
     * @param col, colonne de la case
     * @param color, couleur voulu
     */
    public void setCase(int row, int col, Color color){ 
        this.plateau[row-1][col-1].setColor(color);
    }
    
    /**
     * Permet de savoir si c'est le à notre tour de jouer
     * @param color, couleur du joueur actuel
     * @return true si c'est à notre tour de jouer
     */
    public boolean getTurn(Color color){
        return false;
    }
    
    /**
     * Permet d'afficher le tableau de jeu
     */
    public void afficheTab(){
        
        int colMax = this.colNb;
        
        //affichage des chiffres des colonnes
        System.out.print("  ");
        for(int i = 1 ; i < this.colNb + 1 ; i++){ System.out.print(" " + i); }
        
        //affichage de la ligne du haut
        System.out.println("");
        System.out.print("  +");
        for(int i = 1 ; i < this.colNb + 1 ; i++){ System.out.print("--"); }
        System.out.print("+");
        System.out.println("");
        
        //affichag de toutes les cases
        for(int i = 1 ; i < this.rowNb + 1 ; i++)
        {
            for(int j = 1 ; j < this.colNb + 1 ; j++)
            {
                /*
                if(j == 3){System.out.print(i);}
                else if(j == 5){System.out.print(" |");}
                else if(){System.out.print("|");}
                //else if(this.getCase(i-1, j-1) == Color.NONE){System.out.print("  ");}
                */

                switch(j)
                {
                    case 3:
                        System.out.print(i);
                        break;
                    case 5:
                        System.out.print(" |");
                        break;
                    default:
                        if(j == colMax){System.out.print("|");}
                        else if(this.getCase(i-1, j-1) == Color.NONE){System.out.print("  ");} //décale tout le plateau :((
                }
            }
            System.out.println("");
        }
        
        //affichage de la ligne du bas
        System.out.print("  +");
        for(int i = 1 ; i < this.colNb + 1 ; i++){ System.out.print("--"); }
        System.out.print("+");
        System.out.println("");
               
    }
    
}
