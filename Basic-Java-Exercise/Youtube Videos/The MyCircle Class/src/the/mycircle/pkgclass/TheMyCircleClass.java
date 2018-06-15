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
public class TheMyCircleClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyPoint point = new MyPoint();
        MyCircle circle = new MyCircle(point , 5);
        
        System.out.println(circle.toString());
    }
    
}
