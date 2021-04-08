package gomoku;

/**
 * Interface permettant de créer les joeurs
 * @author Victor Josso
 */
public interface Players {
    
    final Color couleur = Color.NONE;
    
    Case poseJeu(Plateau platJeu);
    
}
