package gomoku;

import java.util.ArrayList;

/**
 *
 * @author Victor Josso
 */
public class Utils {
    
    /**
     * Vérifie la validité des éléments rentrer par l'utilisateur
     * @param refS, string de coordonée
     * @param refMax, nombre référence max
     * @return true si les conditions sont remplies, sinon false
     */
    boolean inputValidation(String refS, int refMax){
        
        try{
                int ref = Integer.parseInt(refS);
                if(ref < 0 || ref > refMax){ System.out.println("-> Indice invalide");}
                else { return true; }
            } catch (Exception e){
                System.out.println("-> Tu n'as pas rentré un nombre");
            }
        
        return false;
    }
    
    /**
     * Vérifie que les coordonées soit dans le tableau
     * @param row, numéro de la ligne
     * @param col, numéro de la colonne
     * @param maxR, numéro max de la ligne
     * @param maxC, numéro max de la colonne
     * @return true si les conditions sont respectées, sinon false
     */
    public boolean inRange(int row, int col, int maxR, int maxC){if(row<=0||row>maxR||col<=0||col>maxC){return false;} return true;}
    
    /**
     * Vérifie la présence de pions dans les cases autour d'une case spécifique
     * @param platJeu, plateau sur lequel se déroule le jeu
     * @param c, la case qui nous intéresse
     * @return vrai si il y a des pion voisins, sinon false
     */
    public boolean pionsVoisins(Plateau platJeu, Case c){
        
        //Nord
        if(inRange(c.getRow()-1, c.getCol(), platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()-1, c.getCol())!=Color.NONE){return true;}
        }
        //Nord-Est
        if(inRange(c.getRow()-1, c.getCol()+1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()-1, c.getCol()+1)!=Color.NONE){return true;}
        }
        //Est
        if(inRange(c.getRow(), c.getCol()+1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow(), c.getCol()+1)!=Color.NONE){return true;}
        }
        //Sud-Est
        if(inRange(c.getRow()+1, c.getCol()+1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()+1, c.getCol()+1)!=Color.NONE){return true;}
        }
        //Sud
        if(inRange(c.getRow()+1, c.getCol(), platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()+1, c.getCol())!=Color.NONE){return true;}
        }
        //Sud-Ouest
        if(inRange(c.getRow()+1, c.getCol()-1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()+1, c.getCol()-1)!=Color.NONE){return true;}
        }
        //Ouest
        if(inRange(c.getRow(), c.getCol()-1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow(), c.getCol()-1)!=Color.NONE){return true;}
        }
        //Nord-Ouest
        if(inRange(c.getRow()-1, c.getCol()-1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()-1, c.getCol()-1)!=Color.NONE){return true;}
        }
        
        return false;
    }
    
    /**
     * Détermine les cases libres autour d'une dite case
     * @param c, la case concerné
     * @param platJeu, le plateau sur lequel se déroule la partie
     * @return l'ensemble des espaces libre autour d'une case
     */
    public ArrayList poseFree(Case c, Plateau platJeu){
        ArrayList<Case> voisins = new ArrayList<Case>();
        
        //Nord
        if(inRange(c.getRow()-1, c.getCol(), platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()-1, c.getCol())==Color.NONE){Case voisin = new Case(c.getRow()-1, c.getCol()); voisins.add(voisin);}
        }
        //Nord-Est
        if(inRange(c.getRow()-1, c.getCol()+1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()-1, c.getCol()+1)==Color.NONE){Case voisin = new Case(c.getRow()-1, c.getCol()+1); voisins.add(voisin);}
        }
        //Est
        if(inRange(c.getRow(), c.getCol()+1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow(), c.getCol()+1)==Color.NONE){Case voisin = new Case(c.getRow(), c.getCol()+1); voisins.add(voisin);}
        }
        //Sud-Est
        if(inRange(c.getRow()+1, c.getCol()+1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()+1, c.getCol()+1)==Color.NONE){Case voisin = new Case(c.getRow()+1, c.getCol()+1); voisins.add(voisin);}
        }
        //Sud
        if(inRange(c.getRow()+1, c.getCol(), platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()+1, c.getCol())==Color.NONE){Case voisin = new Case(c.getRow()+1, c.getCol()); voisins.add(voisin);}
        }
        //Sud-Ouest
        if(inRange(c.getRow()+1, c.getCol()-1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()+1, c.getCol()-1)==Color.NONE){Case voisin = new Case(c.getRow()+1, c.getCol()-1); voisins.add(voisin);}
        }
        //Ouest
        if(inRange(c.getRow(), c.getCol()-1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow(), c.getCol()-1)==Color.NONE){Case voisin = new Case(c.getRow(), c.getCol()-1); voisins.add(voisin);}
        }
        //Nord-Ouest
        if(inRange(c.getRow()-1, c.getCol()-1, platJeu.getNbRows(), platJeu.getNbCols())){
            if(platJeu.getCase(c.getRow()-1, c.getCol()-1)==Color.NONE){Case voisin = new Case(c.getRow()-1, c.getCol()-1); voisins.add(voisin);}
        }
        
        return voisins;
    }
}
