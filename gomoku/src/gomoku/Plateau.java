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
     * @param row
     * @param col 
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
     * @param row
     * @param col
     * @return la case demander
     */
    public Color getCase(int row, int col){
        return this.plateau[row][col].getColor();
    }
            
    /**
     * Initialise la couleur d'une case
     * @param row
     * @param col
     * @param color 
     */
    public void setCase(int row, int col, Color color){ 
        this.plateau[row-1][col-1].setColor(color);
    }
    
    /**
     * Permet de savoir si c'est le à notre tour de jouer
     * @return true si c'est à notre tour de jouer
     */
    public boolean getTurn(){
        return false;
    }
    
    /**
     * Permet d'afficher le tableau de jeu
     */
    public void afficheTab(){
        for(int i = 1 ; i < this.colNb + 1 ; i++){
            System.out.print(" " + i);
        }
        System.out.println("");
        System.out.print("+");
        for(int i = 1 ; i < this.colNb + 1 ; i++){
            System.out.print("_");
        }
        
    }
    
}
