/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.mytriangle.pkgclass;

/**
 *
 * @author SayefReyadh
 */
public class MyTriangle {

    private MyPoint v1 = new MyPoint();
    private MyPoint v2 = new MyPoint();
    private MyPoint v3 = new MyPoint();

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1.setXY(x1, y1);
        this.v2.setXY(x2, y2);
        this.v3.setXY(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "Triangle @ (" + v1.getX() + "," + v1.getY() + "),(" + v2.getX() + "," + v2.getY() + "),(" + v3.getX() + "," + v3.getY() + ")";
    }

    public double getPerimeter() {
        double perimeter = (double) v1.distance(v2.getX(), v2.getY()) + v2.distance(v3.getX(), v3.getY()) + v3.distance(v1.getX(), v1.getY());

        return perimeter;
    }

    public void printType() {
        if (v1.distance(v2.getX(), v2.getY()) == v2.distance(v3.getX(), v3.getY()) && v2.distance(v3.getX(), v3.getY()) == v3.distance(v1.getX(), v1.getY()) && v3.distance(v1.getX(), v1.getY()) == v1.distance(v2.getX(), v2.getY())) {
            System.out.println("equilateral");
        } else if (v1.distance(v2.getX(), v2.getY()) != v2.distance(v3.getX(), v3.getY()) && v2.distance(v3.getX(), v3.getY()) != v3.distance(v1.getX(), v1.getY()) && v3.distance(v1.getX(), v1.getY()) != v1.distance(v2.getX(), v2.getY())) {
            System.out.println("scalene");
        } else if (v1.distance(v2.getX(), v2.getY()) == v2.distance(v3.getX(), v3.getY()) || v2.distance(v3.getX(), v3.getY()) == v3.distance(v1.getX(), v1.getY()) || v3.distance(v1.getX(), v1.getY()) == v1.distance(v2.getX(), v2.getY())) {
            System.out.println("isosceles");
        }

    }

}
