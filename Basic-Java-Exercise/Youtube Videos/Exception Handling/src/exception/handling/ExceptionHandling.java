package exception.handling;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SayefReyadh
 */
public class ExceptionHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Account account = new Account(1000);

        
        
        try {
            account.withdraw(400);
        } catch (AccountException ex) {
            ex.increaseAmount();
        }
        finally{
            System.out.println(account.getAmount());
        }
        

    }

}
