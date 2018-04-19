/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecicleclass;

/**
 *
 * @author SayefReyadh
 */
public class TheCicleClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        Cicle c1 = new Cicle();
        System.out.println("Radius of the circle is " + c1.getRadius() 
                + " Area of the circle is " + c1.getArea());
        Cicle c2 = new Cicle(3.0);
        System.out.println("Radius of the circle is " + c2.getRadius() 
                + " Area of the circle is " + c2.getArea());
        
        Cicle c3 = new Cicle(3.0 , "BLACK");
        System.out.println("Radius of the circle is " + c3.getRadius() 
                + " Area of the circle is " + c3.getArea() );
        
        
    }
    
}
