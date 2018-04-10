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
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle rc = new Rectangle();
        Circle c = new Circle();
        Square s = new Square();
        Shape sh = new Shape();
        
        System.out.println(rc);
        System.out.println(rc.getArea());
        System.out.println(rc.getPerimeter());
        rc.setLength(10);
        rc.setWidth(5);
        System.out.println(rc.getArea());
        System.out.println(rc.getPerimeter());
        
        
        System.out.println(c);
        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());
        c.setRadius(5);
        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());
        
        System.out.println(s);
        System.out.println(s.getSide());
        s.setSide(10);
        System.out.println(s.getSide());
        
        System.out.println(sh);
        System.out.println(sh.getColor());
        sh.setColor("blue");
        System.out.println(sh.getColor());
        
        
        
    }
    
}
