/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.mycomplex.pkgclass;

/**
 *
 * @author SayefReyadh
 */


public class MyComplex {

    private double real;
    private double imag;
    private final static double EPSILON = 0.00000001;
    
    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }

    public boolean isReal() {
        return this.imag == 0;
    }

    public boolean isImaginary() {
        return this.real == 0;
    }

    public boolean equals(double real, double imag) {
        
        if((this.real == real )&& (this.imag == imag))
        {
            return true;
        }
        else if(( Math.abs(this.real - real) < EPSILON ) && (Math.abs(this.imag - imag) < EPSILON))
        {
            return true;
        }
        else
            return false;
    
    }

    public boolean equals(MyComplex another) {
        
        if((this.real == another.getReal())&& (this.imag == another.getImag()))
        {
            return true;
        }
        else if(( Math.abs(this.real - another.getReal()) < EPSILON ) && (Math.abs(this.imag - another.getImag()) < EPSILON))
        {
            return true;
        }
        else
            return false;
    
    
    } 
    /*
    Comparing doubles in equal() using "==" may produce unexpected outcome. For
    example, (2.2+4.4)==6.6 returns false. It is common to define a small threshold
    called EPSILON (set to about 10^-8) for comparing floating point numbers.
    */

    public double magnitude() {
        return (double) Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public double argumentInRadians() {

        return (double) Math.atan2(this.imag, this.real);
    }

    public int argumentInDegrees() {

        return (int) Math.atan2(this.imag, this.real);
    }

    public MyComplex conjugate() {

        return new MyComplex(this.real, -1 * this.imag); // construct a new instance and return the constructed instance
    }

    public MyComplex add(MyComplex another) {

        return new MyComplex(this.real + another.getReal(), this.imag + another.getImag());
    }

    public MyComplex subtract(MyComplex another) {
        return new MyComplex(this.real - another.getReal(), this.imag - another.getImag());
    }

    public MyComplex multiplyWith(MyComplex another) {
        double a, b, c, d;
        a = this.real;
        b = this.imag;
        c = another.getReal();
        d = another.getImag();

        this.real = (double) (a * c - b * d);
        this.imag = (double) (a * d + b * c);

        

        return this;
    }

    public MyComplex divideBy(MyComplex another) {
        double a, b, c, d;
        a = this.real;
        b = this.imag;
        c = another.getReal();
        d = another.getImag();

        this.real = (double) (a * c + b * d) / (c * c + d * d);
        this.imag = (double) (b * c - a * d) / (c * c + d * d);
        
        
        return this;
    }
}
