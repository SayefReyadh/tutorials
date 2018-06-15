/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.mypoint.pkgclass;

/**
 *
 * @author SayefReyadh
 */
public class TestMyPoint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Test program
        MyPoint p1 = new MyPoint(3, 0);
        MyPoint p2 = new MyPoint(0, 4);

        // Testing the overloaded method distance()
        System.out.println(p1.distance(p2)); // which version?
        System.out.println(p1.distance(5, 6)); // which version?
        
        MyPoint points[] = new MyPoint[10];
        
        for(int i=0 ; i<10 ; i++)
        {
            points[i] = new MyPoint(i+1 , i+1);
            ///System.out.println(points[i].toString());
        }
    }

}
