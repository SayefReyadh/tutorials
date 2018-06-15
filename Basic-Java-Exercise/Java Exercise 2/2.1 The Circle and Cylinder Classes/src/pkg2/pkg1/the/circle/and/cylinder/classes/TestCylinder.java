/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.pkg1.the.circle.and.cylinder.classes;

/**
 *
 * @author SayefReyadh
 */
public class TestCylinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println("Cylinder:"+ " radius=" + c1.getRadius()+ " height=" + c1.getHeight()+ " surface area=" + c1.getArea()+ " volume=" + c1.getVolume());
        Cylinder c2 = new Cylinder(10.0);
        System.out.println("Cylinder:"+ " radius=" + c2.getRadius()+ " height=" + c2.getHeight()+ " surface area=" + c2.getArea()+ " volume=" + c2.getVolume());
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("Cylinder:" + " radius=" + c3.getRadius() + " height=" + c3.getHeight() + " surface area=" + c3.getArea()+ " volume=" + c3.getVolume());
    
        System.out.println(c1); /// toString Method overide  
        
        
        /// After overiding the getArea method
        /// Dynamic method dispatch
        Circle c = new Circle(); /// Use the default values
        Circle r; /// referencial variable
        r = c3; /// Cylinder object c3
        System.out.println(r.getArea());
        r = c; /// Circle Object c
        System.out.println(r.getArea());
    }

}
