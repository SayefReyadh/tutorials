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
public class TestMyCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyPoint point = new MyPoint(0,0);
        MyCircle circle = new MyCircle(0,0,5);
        MyCircle circle2 = new MyCircle(new MyPoint(1,1),5);
        
        System.out.println(circle.getRadius());
        circle.setRadius(6);
        
        System.out.println(circle2.getCenter());
        circle2.setCenter(point);
        
        System.out.println(circle.getCenterX() + " " + circle.getCenterY());
        circle.setCenterXY(2, 2);
        
        System.out.println(circle.toString());
        System.out.println(circle2.toString());

        
        System.out.println(circle.getArea());
        System.out.println(circle2.getArea());
    }
    
}
