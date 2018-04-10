/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.mytriangle.pkgclass;

/**
 *
 * @author SayefReyadh
 */
public class TestMyTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyPoint point1 = new MyPoint(4,4);
        MyPoint point2 = new MyPoint(5,5);
        MyPoint point3 = new MyPoint(6,6);
        MyTriangle triangle = new MyTriangle(0,0,1,1,2,2);
        MyTriangle triangle2 = new MyTriangle(point1 , point2 , point3);
        
        System.out.println(triangle.toString());
        System.out.println(triangle2.toString());
        System.out.println(triangle.getPerimeter());
        triangle.printType();
    }
    
}
