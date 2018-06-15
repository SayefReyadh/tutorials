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
public class Triangle extends Figure{

    public Triangle(double dimensionOne, double dimensionTwo) {
        super(dimensionOne, dimensionTwo);
    }

    @Override
    public double calculateArea() {
        return 0.5 * getDimensionOne() * getDimensionTwo();
    }

    
}
