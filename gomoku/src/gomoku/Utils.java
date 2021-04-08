package gomoku;

/**
 *
 * @author Victor Josso
 */
public class Utils {
    
    boolean inputValidation(String refS, int refMax){
        
        boolean valid = false;
        
        try{
                int ref = Integer.parseInt(refS);
                if(ref < 0 || ref > refMax){ System.out.println("-> Indice invalide");}
                else { valid = true; }
            } catch (Exception e){
                System.out.println("-> Tu n'as pas rentré un nombre");
            }
        
        return valid;
    }
}
