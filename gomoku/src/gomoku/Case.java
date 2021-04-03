package gomoku;

/**
 *Class Case regroupant les coordonnées de chaque case ainsi que leur couleur
 * 
 * @author Victor Josso
 */
public class Case {
   
    private final int row, col;
    private Color color;
    
    /**
     * Constructeur de la classe Case
     * @param row, ligne de la case
     * @param col, colonne de la case
     */
    public Case(int row, int col){
        this.row = row;
        this.col = col;
        this.color = Color.NONE;
    }
    
    /**
     * Initialise une couleur pour une instance de la classe
     * @param color 
     */
    public void setColor(Color color){
        this.color = color;
    }
    
    /**
     * Permet d'obtenir la couleur de la case qui nous interesse 
     * @return la couleur de la case 
     */
    public Color getColor(){
        return this.color;
    }
    
    /**
     * Getteur permetant d'obtenir la ligne
     * @return le nombre de la ligne où se situe la case
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * Getteur permettant d'obtenir la colonne
     * @return le nombre de colonne où se situe la case
     */
    public int getCol(){
        return this.col;
    }
}
