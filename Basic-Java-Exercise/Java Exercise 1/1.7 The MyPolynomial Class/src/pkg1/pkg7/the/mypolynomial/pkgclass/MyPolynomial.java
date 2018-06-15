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
public class MyPolynomial {

    private double coeffs[];

    //public MyPolynomial(double[] coeffs) {
      //  this.coeffs = coeffs;
    //}

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }
    
    

    public int getDegree() {
        return coeffs.length-1;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = coeffs.length - 1 ; i>=0 ; i--)
        {   
            str +=coeffs[i];
            if(i!=0)
                str += "X";
            if(i!=0 && i!=1)
                str+="^"+i;
            if(i!=0)
                str+="+";
        } 
        
        
        //System.out.println(str);
        return str;
    }
    
    
    public double evaluate(double x) {
        double ans = 0;
        for(int i = coeffs.length -1 ; i>=0 ; i--)
        {
            ans += coeffs[i]*Math.pow(coeffs[i], i);
        }
        
        
        return ans;
    }

    public MyPolynomial add(MyPolynomial another) {
        
        double c[] = new double[coeffs.length];
        for(int i =0 ; i<coeffs.length ; i++)
        {
            c[i] = (double) coeffs[i] + another.getCoeffs()[i];
        }
        return new MyPolynomial(c);
    }

    public MyPolynomial multiply(MyPolynomial another) {

        
        double c[] = new double[coeffs.length];
        for(int i =0 ; i<coeffs.length ; i++)
        {
            c[i] = (double) coeffs[i] * another.getCoeffs()[i];
        }
        return new MyPolynomial(c);
        
    }

    public double[] getCoeffs() {
        return coeffs;
    }
    
    

}
