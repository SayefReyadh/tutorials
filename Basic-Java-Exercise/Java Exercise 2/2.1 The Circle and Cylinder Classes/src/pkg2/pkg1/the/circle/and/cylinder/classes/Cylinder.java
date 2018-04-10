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
public class Cylinder extends Circle {

    private double height; 

    public Cylinder() {
        ///no need to call the super constructor as there is a default super() called
        height = 1.0;
    }
   

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius); 
        this.height = height;
    }
    

    public double getHeight() {
        return height;
    }
    

    public double getVolume() {
        return (double) super.getArea() * height;
    }

    @Override
    public double getArea() {
        return (double) 2 * Math.PI * super.getRadius() * this.height + 2 * super.getArea();
    }

    @Override
    public String toString() { // in Cylinder class
        return "Cylinder: subclass of " + super.toString() + " height=" + height;
    }

}
