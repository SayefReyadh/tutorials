/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SayefReyadh
 */

package circle;

import java.util.Scanner;

public class TestCircle {

    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        
        
        Circle c1 = new Circle();
        
        System.out.println("The circle has radius of " + c1.getRadius() + " and area of " + c1.getArea());
        System.out.println("The circle has colour of " + c1.getColor());
       
        Circle c2 = new Circle(2.0);
        
        System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.getArea());
        System.out.println("The circle has colour of " + c2.getColor());
        
        Circle c3 = new Circle(3.0, "green");
        
        System.out.println("The circle has radius of " + c3.getRadius() + " and area of " + c3.getArea());
        System.out.println("The circle has colour of " + c3.getColor());
        
        ///Test Setter Method
        Circle c4 = new Circle();        
        c4.setRadius(5.0);
        c4.setColor("blue");
        
        ///Try 
        ///c1.radius = 1.5;   /// As the class variables were private only the class method can access those variables to change them if we want
        ///System.out.println(c1.radius); ///As the class variables were private only the class method can access those variables
    
        ///toString()
        System.out.println();
        Circle c5 = new Circle(5.0);
        System.out.println(c5.toString()); // explicit call
        System.out.println(c5);  // println() calls toString() implicitly, same as above
        System.out.println("Operator '+' invokes toString() too: " + c2); //'+' invokes toString() too
        
    }
}
