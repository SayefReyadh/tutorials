/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.mycomplex.pkgclass;

import static java.lang.System.out;

import java.util.Scanner;

/**
 *
 * @author SayefReyadh
 */
public class MyComplexApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        out.print("Enter complex number 1 (real and imaginary part): ");
        double real = sc.nextDouble();
        double imag = sc.nextDouble();

        MyComplex complex1 = new MyComplex(real, imag);

        out.print("Enter complex number 2 (real and imaginary part): ");
        real = sc.nextDouble();
        imag = sc.nextDouble();

        MyComplex complex2 = new MyComplex(real, imag);

        check(complex1);
        check(complex2);

        if (complex1.equals(complex2)) {
            out.println(complex1.toString() + " is equal to " + complex2.toString());
        } else {
            out.println(complex1.toString() + " is NOT equal to " + complex2.toString());
        }
        
        MyComplex add , sub;
        add = complex1.add(complex2);
        sub = complex1.subtract(complex2);
        
        out.println(complex1.toString() + " + " + complex2.toString() + " = " +add.toString());
        out.println(complex1.toString() + " - " + complex2.toString() + " = " +sub.toString());
        
        MyComplex temp = complex1;        
        complex1.multiplyWith(complex2); /// Multiply        
        complex1 = temp;        
        complex1.divideBy(complex2); /// Divide
        complex1 = temp;
        
        out.println("magnitude is " + complex1.magnitude()); ///Magnitude
        out.println("argumentInRadians is " + complex1.argumentInRadians()); ///Radians        
        out.println("argumentInDegrees is " + complex1.argumentInDegrees()); ///Degrees
        
        MyComplex conjugate = complex1.conjugate();
    }

    public static void check(MyComplex complex) {
        out.println("Number 1 is: " + complex.toString());

        if (complex.isReal()) {
            ///out.println(complex1.isReal());
            out.println(complex.toString() + " is a pure real number");
        } else {
            ///out.println(complex1.isReal());
            out.println(complex.toString() + " is NOT a pure real number");
        }

        if (complex.isImaginary()) {
            ///out.println(complex1.isImaginary());
            out.println(complex.toString() + " is a pure imaginary number");
        } else {
            ///out.println(complex1.isImaginary());
            out.println(complex.toString() + " is NOT a pure imaginary number");
        }
    }

}
