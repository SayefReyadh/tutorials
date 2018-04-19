/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpackage;

/**
 *
 * @author SayefReyadh
 */
public abstract class Figure {
    private double dimensionOne;
    private double dimensionTwo;

    public Figure(double dimensionOne, double dimensionTwo) {
        this.dimensionOne = dimensionOne;
        this.dimensionTwo = dimensionTwo;
    }

    public double getDimensionOne() {
        return dimensionOne;
    }

    public void setDimensionOne(double dimensionOne) {
        this.dimensionOne = dimensionOne;
    }

    public double getDimensionTwo() {
        return dimensionTwo;
    }

    public void setDimensionTwo(double dimensionTwo) {
        this.dimensionTwo = dimensionTwo;
    }

    @Override
    public String toString() {
        return "Figure{" + "dimensionOne=" + dimensionOne + ", dimensionTwo=" + dimensionTwo + '}';
    }
    
    public abstract double calculateArea();
    
}
