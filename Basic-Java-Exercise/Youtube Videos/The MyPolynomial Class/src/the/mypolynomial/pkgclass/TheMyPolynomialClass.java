/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.mypolynomial.pkgclass;

/**
 *
 * @author SayefReyadh
 */
public class TheMyPolynomialClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyPolynomial p1 = new MyPolynomial(1, 2, 5);
        MyPolynomial p3 = new MyPolynomial(1, 3, 3);
        
        System.out.println(p1);
        MyPolynomial add , mul;
        
        add = p1.add(p3);
        mul = p1.multiply(p3);
        System.out.println(mul);
    }
    
}
