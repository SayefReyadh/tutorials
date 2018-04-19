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
public class Cicle {
    private double radius;
    private String color;

    public Cicle() {
        this.radius = 1.0;
        this.color = "Red";
    }

    public Cicle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Cicle(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
    
    
    @Override
    public String toString() {
        return "radius=" + radius + ", color=" + color;
    }
    
    
    
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
    
}
