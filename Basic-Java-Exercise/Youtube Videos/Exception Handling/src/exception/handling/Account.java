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
public class Account {
    private int amount;

    
    
    public Account(int amount) {
        this.amount = amount;
    }
    
    public void deposit(int amount) throws AccountException
    {
        if(amount < 0)
        {
            throw new AccountException(amount);
        }
        this.amount += amount;
    }
    
    public void withdraw(int amount) throws AccountException
    {
        if(this.amount < amount)
        {
            throw new AccountException(this , amount);
        }
        
        this.amount -= amount;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
