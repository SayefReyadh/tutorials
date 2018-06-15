/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception.handling;

/**
 *
 * @author SayefReyadh
 */
public class AccountException extends Exception {

    public Account account;
    public int amount;

    public AccountException(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    
    public AccountException(int amount) {
        this.amount = amount;
    }
    
    
    
    public AccountException() {
        System.out.println("THIS IS ACCOUNT EXCEPTION");
    }

    public AccountException(String message) {
        super(message);
    }
    
    
    public int correctAmount()
    {
        if(this.amount < 0)
            return -1 * amount;
        else
            return amount;
    }
    
    public void increaseAmount()
    {
        account.setAmount(amount);
    }
    
    
    
}
