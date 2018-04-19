/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomplexclass;

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

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
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
        if (imag < 0) {
            return "(" + real + " " + imag + "i)";
        } else {
            return "(" + real + " +" + imag + "i)";
        }
    }

    public boolean isReal() {
        return this.real == 0;
    }

    public boolean isImag() {
        return this.imag == 0;
    }

    public boolean equals(double real, double imag) {
        if ((this.real == real) && (this.imag == imag)) {
            return true;
        } else if ((Math.abs(this.real - real) < EPSILON) && (Math.abs(this.imag - imag) < EPSILON)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(MyComplex another) {
        double real = another.getReal();
        double imag = another.getImag();

        if ((this.real == real) && (this.imag == imag)) {
            return true;
        } else if ((Math.abs(this.real - real) < EPSILON) && (Math.abs(this.imag - imag) < EPSILON)) {
            return true;
        } else {
            return false;
        }
    }

    /*
    Comparing doubles in equal() using "==" may produce unexpected outcome. For
    example, (2.2+4.4)==6.6 returns false. It is common to define a small threshold
    called EPSILON (set to about 10^-8) for comparing floating point numbers.
     */
    public double magnitude() {
        return (double) Math.sqrt(real * real + imag * imag);
    }

    public double argumentInRadians() {
        return (double) Math.atan2(imag, real);
    }

    public double argumentInDegrees() {
        return (int) Math.atan2(imag, real);
    }

    public MyComplex conjugate() {
        MyComplex objComplex = new MyComplex(real, -1 * imag);
        //return new MyComplex(real, -1*imag);
        return objComplex;
//on the fly creating a new object
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
