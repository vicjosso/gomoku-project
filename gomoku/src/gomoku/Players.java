package gomoku;

/**
 * Interface permettant de créer les joeurs
 * @author Victor Josso
 */
public interface Players {
    
    final Color couleur = Color.NONE;
    
    /**
     * Détermine le placement de la case
     * @param platJeu, plateau sur lequel le jeu se déroule
     * @return pose, placement de la case 
     */
    Case poseJeu(Plateau platJeu);
    
}
