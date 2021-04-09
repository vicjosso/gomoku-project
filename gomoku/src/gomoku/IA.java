package gomoku;

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
    public Case poseJeu(Plateau platJeu){
        System.out.println("L'IA joue....");
        
        int row = 0;
        int col = 0;
        
        boolean valide = false;
        
        /*
        for(int i = 0; i < platJeu.getNbRows(); i++)
        {
            for(int j = 0; j < platJeu.getNbCols(); j++)
            {
                if(platJeu.getCase(i, j) == Color.WHITE){}
                else if(platJeu.getCase(i, j) == Color.BLACK){}
            }
        }
        */
        
        do {
            
            row = 1+Math.round(platJeu.getNbRows()-1); 
            col = 1+Math.round(platJeu.getNbCols()-1); 
            
            if(platJeu.getCase(row, col) == Color.NONE){ valide = true;} //verifier offset
        } while(!valide);
        
        
        
        Case pose = new Case(row, col);
        
        return pose;
    }
    
}
