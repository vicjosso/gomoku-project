/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

/**
 *
 * @author Victor Josso
 */
public class Case {
    enum Color {BLACK, WHITE, NONE};
    
    final int row, col;
    Color color = Color.NONE;
    
    public Case(int row, int col){
        this.row = row;
        this.col = col;        
    }
    
    void SetColor(Color color){
        this.color = color;
    }
}
