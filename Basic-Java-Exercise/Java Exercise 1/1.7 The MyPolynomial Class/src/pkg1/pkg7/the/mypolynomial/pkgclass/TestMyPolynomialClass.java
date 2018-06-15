/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.pkg7.the.mypolynomial.pkgclass;

/**
 *
 * @author SayefReyadh
 */
public class TestMyPolynomialClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3);
        MyPolynomial p3 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);

        
        System.out.println(p1.toString());
        
        double c[] = {1.2, 3.4, 5.6, 7.8};
        
        MyPolynomial p2 = new MyPolynomial(c);
        
        System.out.println(p1.getDegree());
        System.out.println(p1.evaluate(1));
        System.out.println();
        
        MyPolynomial add , mul;
        
        add = p1.add(p3);
        mul = p1.multiply(p3);
        
    }

}
