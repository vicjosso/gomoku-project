

import gomoku.Case;
import gomoku.Color;
import gomoku.Plateau;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 * Class de Test pour l'ensemble des classes du projet
 * 
 * @author Victor Josso
 */
public class TestGomoku {
    
    @Test
    public void testCase(){
        // créer deux instances de Case
        Case p1 = new Case(2, 3);
        Case p2 = new Case(2, 3);
        
        // verifier que getCol/getRow retournent les bonnes valeurs
        assertEquals(2, p2.getRow());
        assertEquals(3, p2.getCol());
        
        // verifier que p1 est egal à p2  (`equals`)
        assertEquals(p1.getRow(), p2.getRow());
        assertEquals(p1.getCol(), p2.getCol());
        
        // verifier la couleur de base
        assertEquals(p1.getColor(), Color.NONE);
        assertEquals(p1.getColor(), p2.getColor());
        
        // verifier l'initialisation d'une nouvelle couleur
        p1.setColor(Color.WHITE);
        assertEquals(p1.getColor(), Color.WHITE);
        
    }
    
    @Test
    public void testPlateau(){
        //créer deux instance du Plateau
        Plateau plat1 = new Plateau(10, 10);
        Plateau plat2 = new Plateau(10, 20);
    
        //verifier que getNbRow/getCol retournent les bonnes valeurs
        assertEquals(plat1.getNbRows(), 10);
        assertEquals(plat2.getNbCols(), 20);
        
        //verifier que plat1 est egal a plat2
        assertEquals(plat1.getNbRows(), plat2.getNbRows());
        
        //verifier la couleur d'une case
        assertEquals(plat2.getCase(2, 2), Color.NONE);  
        
        //verifier la setteur de couleur de la case
        plat1.setCase(5, 5, Color.WHITE); 
        plat2.setCase(10, 20, Color.BLACK);
        
    }
    
    @Test
    public void testAffichagePlateau(){
        //création d'un nouveau plateau
        Plateau plat1 = new Plateau(25, 15);
        
        //création de points
        plat1.setCase(5, 5, Color.WHITE);
        plat1.setCase(10, 10, Color.BLACK);
        
        //affichage du tableau
        plat1.afficheTab();
        
    }
    
    @Test
    public void posagePions(){
        //création d'un plateau
        Plateau plat1 = new Plateau(25, 15);
        
        
    }

}
