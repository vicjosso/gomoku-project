package gomoku;

import java.util.ArrayList;

/**
 *
 * @author Victor Josso
 */
public class Plateau {
    
    final private int row;
    final private int col;
    
    Case.Color turn;
    
    Case[][] plateau;
    
    /**
     * 
     * @param row
     * @param col 
     */
    public Plateau(int row, int col){
        this.row = row;
        this.col = col;
        this.plateau = new Case[row][col];
    }
    
    /**
     * 
     * @return le nombre de ligne du tableau
     */
    public int getNbRows(){
        return this.row;
    }
    
    /**
     * 
     * @return le nombre de colonne du tableau
     */
    public int getNbCols(){
        return this.col;
    }
     
    /**
     * 
     * @param row
     * @param col
     * @return la case demander
     */
    public Case getCase(int row, int col){
        return this.plateau[row][col];
    }
            
    /**
     * 
     * @param row
     * @param col
     * @param color 
     */
    public void setCase(int row, int col, Case.Color color){ 
        this.plateau[row][col].setColor(color);
    }
    
    /**
     * 
     * @return true si c'est à notre tour de jouer
     */
    public boolean getTurn(){
        return false;
    }
}
