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
public class Square extends Rectangle{
    public Square() {
    }

    public Square(double side) {
        super(side,side);
    }

    public Square(double side, String color, boolean filled) {
        super(side,side);
        super.setColor(color);
        super.setFilled(filled);
        
        
    }

    public double getSide() {
        return super.getLength();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);        
        super.setWidth(length);
    }

    @Override
    public String toString() {
        return "A Square with side="+super.getLength()+", which is a subclass of "+super.toString();
    }
    
    
    
}
