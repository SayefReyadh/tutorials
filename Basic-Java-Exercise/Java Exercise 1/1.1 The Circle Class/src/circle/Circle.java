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

import java.util.Objects;

public class Circle {

    
    // private instance variable, not accessible from outside this class
    private double radius;
    private String color;
    // 1st constructor, which sets both radius and color to default

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }
    // 2nd constructor with given radius, but color default

    public Circle(double r) {
        this.radius = r;
        this.color = "red";
    }
    // A public method for retrieving the radius

    public Circle(double r, String c) {
        this.radius = r;
        this.color = c;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public double getRadius() {
        return this.radius;
    }
    // A public method for computing the area of circle

    public String getColor() {
        return this.color;
    }
    
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

   
    public String toString() {
        return "Circle: radius=" + this.radius + " color=" + this.color;
    }

    
    
    


}
