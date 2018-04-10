/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SayefReyadh
 */

package pkg2.pkg1.the.circle.and.cylinder.classes;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    public double getRadius() {
        return this.radius;
    }
    
    public double getArea() {
        return (double) this.radius * this.radius * Math.PI;
    }

   
    @Override
    public String toString() {
        return "Circle: radius=" + this.radius + " color=" + this.color;
    }

    
    
    


}
