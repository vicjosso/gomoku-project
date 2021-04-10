import gomoku.Case;
import gomoku.Color;
import gomoku.Game;
import gomoku.Plateau;
import gomoku.Utils;
import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 * Class de Test pour l'ensemble des classes du projet
 * 
 * @author Victor Josso
 */
public class TestGomoku {
    
    //Test de la classe case
    
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
    
    //test de la classe tableau
    
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
    
    //Test de la classe game
    // non fonctionnel pour des raisons inconnues...
    @Test
    public void testCheckWin(){
        //création du tableau
        Plateau plat = new Plateau(10, 10);
        Game jeu = new Game();
        
        //placement des pions
        plat.setCase(1, 1, Color.WHITE);
        plat.setCase(1, 2, Color.WHITE);
        plat.setCase(1, 3, Color.WHITE);
        plat.setCase(1, 4, Color.WHITE);
        plat.setCase(1, 5, Color.WHITE);
        
        //affichage tableau
        plat.afficheTab();
        
        //vérification de la victoire
        assertEquals(jeu.checkWin(plat), true);
        
        
        Plateau plat1 = new Plateau(10, 10);
        
        //placement des pions
        plat1.setCase(2, 3, Color.BLACK);
        plat1.setCase(3, 3, Color.BLACK);
        plat1.setCase(4, 3, Color.BLACK);
        plat1.setCase(5, 3, Color.BLACK);
        plat1.setCase(6, 3, Color.BLACK);
        
        //affichage tableau
        plat1.afficheTab();
        
        //vérification de la victoire
        assertEquals(jeu.checkWin(plat1), true);
        
        Plateau plat2 = new Plateau(10, 10);
        
        //placement des pions
        plat2.setCase(10, 10, Color.BLACK);
        plat2.setCase(9, 9, Color.BLACK);
        plat2.setCase(8, 8, Color.BLACK);
        plat2.setCase(7, 7, Color.BLACK);
        plat2.setCase(6, 6, Color.BLACK);
        
        //affichage tableau
        plat2.afficheTab();
        
        //vérification de la victoire
        assertEquals(jeu.checkWin(plat2), true);
        
        Plateau plat3 = new Plateau(10, 10);
        
        //placement des pions
        plat3.setCase(10, 1, Color.WHITE);
        plat3.setCase(9, 2, Color.WHITE);
        plat3.setCase(8, 3, Color.WHITE);
        plat3.setCase(7, 4, Color.WHITE);
        plat3.setCase(6, 5, Color.WHITE);
        
        //affichage tableau
        plat3.afficheTab();
        
        //vérification de la victoire
        assertEquals(jeu.checkWin(plat3), true);
        
    }
    
    @Test
    public void testGame(){
        Plateau plat = new Plateau(2, 2);
        Game jeu = new Game();
        //ajout des pions
        plat.setCase(1, 1, Color.WHITE);
        plat.setCase(2, 2, Color.WHITE);
        plat.setCase(1, 2, Color.BLACK);
        plat.setCase(2, 1, Color.BLACK);
        
        //test checkDraw
        assertEquals(jeu.checkDraw(plat), true);
        
        plat = new Plateau(10, 10);
        
        
        ArrayList<String> played = new ArrayList<String>();
        played.add("patate");
        played.add("miam");
        
        //test resultGame
        jeu.resultGame(true, false, played);
        jeu.resultGame(true, true, played);
        jeu.resultGame(false, false, played);
        
    }
    
    //test de la classe Utils
    
    @Test
    public void testUtils(){
        Plateau plat = new Plateau(10, 10);
        Utils verif = new Utils();
        
        //ajout de pions dans le plateau
        plat.setCase(2, 2, Color.WHITE);
        plat.setCase(7, 7, Color.BLACK);
        plat.setCase(7, 8, Color.WHITE);
        plat.setCase(8, 8, Color.BLACK);
        
        //test inRange
        assertEquals(verif.inRange(-1, 0, plat.getNbRows(), plat.getNbCols()), false);
        assertEquals(verif.inRange(5, 5, plat.getNbRows(), plat.getNbCols()), true);
        assertEquals(verif.inRange(0, 10, plat.getNbRows(), plat.getNbCols()), false);
        assertEquals(verif.inRange(2, 9, plat.getNbRows(), plat.getNbCols()), true);
        assertEquals(verif.inRange(10, 10, plat.getNbRows(), plat.getNbCols()), true);
        
        //test pionsVoisins
        assertEquals(verif.pionsVoisins(plat, new Case(1, 1)), true);
        assertEquals(verif.pionsVoisins(plat, new Case(2, 3)), true);
        assertEquals(verif.pionsVoisins(plat, new Case(5, 5)), false);
        
        //test poseFree
        assertEquals(verif.poseFree(new Case(1, 1), plat).size(), 2);
        assertEquals(verif.poseFree(new Case(2, 2), plat).size(), 8);
        assertEquals(verif.poseFree(new Case(8, 7), plat).size(), 5);
        
    }

}
