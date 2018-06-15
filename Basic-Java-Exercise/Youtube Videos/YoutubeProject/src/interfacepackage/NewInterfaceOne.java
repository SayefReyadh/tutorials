/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacepackage;

/**
 *
 * @author SayefReyadh
 */
public interface NewInterfaceOne extends NewInterfaceTwo{
    int a = 0;
    int b = 20;
    int CREDINTIAL = 10;
    
    void show();
    
    default void print()
    {
        System.out.println("THis is a print method");
    }
    
    default void print2()
    {
        System.out.println("THis is a print method");
    }
    
}
