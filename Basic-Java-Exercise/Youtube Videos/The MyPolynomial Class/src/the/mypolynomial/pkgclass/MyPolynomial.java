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
public class MyPolynomial {

    private double[] coeffs;

//    public MyPolynomial(double[] coeffs) {
//        this.coeffs = coeffs;
//    }
    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String str = "";
        //5x^4 + 7x^3 + 3x^2 + 6x + 10
        for (int i = 0; i < coeffs.length; i++) {
            str += coeffs[i];

            if (i != coeffs.length - 1) {
                str += "x";
            }

            if (i != coeffs.length - 1 && i != coeffs.length - 2) {
                str += "^" + (coeffs.length - 1 - i);
            }

            if (i != coeffs.length-1) {
                str += "+";
            }

        }

        return str;
    }

    public double evaluate(double x) {
        double ans = 0;
        for (int i = coeffs.length - 1 ; i >= 0; i--) {
            ans += coeffs[i] * Math.pow(x, i);
        }

        return ans;
    }

    public MyPolynomial add(MyPolynomial another) {
        double[] c;
        int mx;
        if (coeffs.length > another.getCoeffs().length) {
            mx = coeffs.length;
            c = new double[coeffs.length];
        } else {
            mx = another.getCoeffs().length;
            c = new double[another.getCoeffs().length];
        }
        for (int i = 0; i < mx; i++) {
            c[i] = (double) coeffs[i] + another.getCoeffs()[i];
        }

        return new MyPolynomial(c);

    }
    
    public MyPolynomial multiply(MyPolynomial another) {
        
        int mx = coeffs.length + another.getCoeffs().length - 1; 
        double[] c = new double[mx];
        
        
   
      
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }
        
        /*
            x2 + 2x + 5
            x2 + 3x + 3
        ----------------
           3x2 + 6x + 15
     3x3 + 6x2 + 15x
x4 + 2x3 + 5x2
        */
       
        for(int i = 0 ; i < coeffs.length ;i++)
        {
            
            for(int j = 0 ; j < another.getCoeffs().length ; j++)
            {
                c[i+j] += (double) coeffs[i] * another.getCoeffs()[j];
                
            }
        }
        
        
        return new MyPolynomial(c);

    }

    public double[] getCoeffs() {
        return coeffs;
    }

}
