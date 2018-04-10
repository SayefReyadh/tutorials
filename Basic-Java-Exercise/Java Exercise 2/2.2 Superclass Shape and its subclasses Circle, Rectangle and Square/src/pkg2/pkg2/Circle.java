/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SayefReyadh
 */

package pkg2.pkg2;

public class Circle extends Shape{    
    private double radius;
    
    public Circle() {
        this.radius = 1.0;
    }
    
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    
    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    double getPerimeter()
    {
        return 2*Math.PI*this.radius;
    }

    
    public double getArea() {
        return (double) this.radius * this.radius * Math.PI;
    }

   
    @Override
    public String toString() {
        return "A Circle with radius="+this.radius+", which is a subclass of "+super.toString();
    }

    
    
    


}
