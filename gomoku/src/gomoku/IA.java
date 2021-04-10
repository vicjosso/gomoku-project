package gomoku;

import java.util.ArrayList;

/**
 *
 * @author Victor Josso
 */
public class IA implements Players{
    
    final Color couleur = Color.BLACK;
    
    
    /**
     * Détermine la placement d'un pion
     * @param platJeu, plateau sur lequel le jeu se déroule
     * @return pose, case sélectionnee par l'IA
     */
    @Override
    public Case poseJeu(Plateau platJeu, int nbTour){
        
        Utils verif = new Utils();
        ArrayList<Case> poseP = new ArrayList<Case>();
        
        System.out.println("L'IA joue....");
        
        int row = 0;
        int col = 0;
        
        Case pose = null;
        
        boolean valide = false;
        
        do {
            label:
            for(int i=1;i<platJeu.getNbRows()+1; i++){
                for(int j=1;j<platJeu.getNbCols()+1; j++){
                    if(platJeu.getCase(i, j) != Color.NONE){
                        poseP = verif.poseFree(new Case(i, j), platJeu);
                        if(poseP.size() != 0){
                            pose = poseP.get(0);
                            if(pose!=null){ row=pose.getRow(); col=pose.getCol(); break label;}
                        }
                    }
                }
            }
         
            
            if(platJeu.getCase(row, col) == Color.NONE){ valide = true;} 
        } while(!valide);
        
        return pose;
    }
    
}
