package gomoku;

import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class Joueur implements Players {
    
    static Scanner in = new Scanner(System.in);
    
    final Color couleur = Color.WHITE;
    
    @Override
    public Case poseJeu(Plateau platJeu){
        
        int row = 0;
        int col = 0;
        
        boolean rowOk = false;
        boolean colOk = false;
        boolean valide = false;
        
        do {
            
            //vérification du placmeent pion ligne
            do{
                System.out.println("");
                System.out.print("Insérez la ligne où vous voulez placer votre pion :");
                String ligne = in.nextLine().trim();
                try{
                        row = Integer.parseInt(ligne);
                        if(row < 0 || row > platJeu.getNbRows()){ System.out.println("Indice invalide");}
                        else { rowOk = true; }
                    } catch (Exception e){
                        System.out.println("Tu n'as pas rentré un nombre");
                    }
            }while(!rowOk);
            
            //vérification du placement pion colonne
            do{
                System.out.println("");
                System.out.print("Insérez la colonne où vous voulez placer votre pion :");
                String colonne = in.nextLine().trim();
                try{
                        col = Integer.parseInt(colonne);
                        if(col < 0 || col > platJeu.getNbCols()){ System.out.println("Indice invalide");}
                        else { colOk = true; }
                    } catch (Exception e){
                        System.out.println("Tu n'as pas rentré un nombre");
                    }
            }while(!colOk);
            
            if(platJeu.getCase(row, col) == Color.NONE){ valide = true;}
            else { System.out.println("-> Placement invalide"); rowOk = false; colOk = false; };
        } while(!valide);
        
        Case pose = new Case(row, col);
        
        return pose;
    }
}
