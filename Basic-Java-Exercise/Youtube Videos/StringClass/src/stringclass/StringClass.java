/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringclass;

/**
 *
 * @author SayefReyadh
 */
public class StringClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        char[] ch = {'H' , 'E' , 'L' , 'L' , 'O'};
        
        String string = new String("Hello World");
        String string2 = new String("Hello World");
        String string3 = new String("Hello Worle");
        String string4 = new String("Hello Worlc");
        
        
        string2 += "CSE";
        
        System.out.println(string);
    }
    
}
