/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.pkg2;

/**
 *
 * @author SayefReyadh
 */
public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }
    double getArea()
    {
        return this.width * this.length;
    }
    double getPerimeter()
    {
        return 2*(this.width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="+ this.width+ " and length="+ this.length+ ", which is a subclass of "+super.toString();
    }
    
    
    
}
