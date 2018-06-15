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
public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {
        
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setXY(int x , int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    
    public double distance(int x , int y)
    {
        double ans = (double) ((this.x-x)*(this.x-x) + (this.y-y)*(this.y-y)) ;
        return Math.sqrt(ans);
    }
    public double distance(MyPoint another)
    {
        double ans = (double) ((this.x-another.getX())*(this.x-another.getX()) + (this.y-another.getY())*(this.y-another.getY())) ;
        return Math.sqrt(ans);
    }
    
}
