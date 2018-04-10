/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.mycircle.pkgclass;

/**
 *
 * @author SayefReyadh
 */
public class MyCircle {
    private MyPoint center = new MyPoint();
    private int radius = 1;

        
    public MyCircle(int x , int y , int radius) {
        this.center.setX(x);
        this.center.setY(y);
        this.radius = radius;
    }
    
    
    public MyCircle(MyPoint center , int radius) {
        this.center = center;
        this.radius = radius;
        
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }
    public int getCenterX()
    {
        return this.center.getX();
    }
    public int getCenterY()
    {
        return this.center.getY();
    }
    public void setCenterXY(int x , int y)
    {
        this.center.setX(x);
        this.center.setY(y);
    }

    @Override
    public String toString() {
        return "Circle @ (" + this.center.getX() + "," + this.center.getY() + ") radius=" + this.radius;
    }
    public double getArea()
    {
        double ans = (double) 3.1416*this.radius*this.radius;
        return ans;
    }
    
    
}
