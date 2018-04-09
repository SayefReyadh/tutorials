/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.balls.ball.and.container.classes;

/**
 *
 * @author SayefReyadh
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Ball ob = new Ball(50, 50, 5, 10, 30);
        System.out.println(ob);
        ob.setXY(0, 0);
        ob.setRadius(0);
        ob.reflectHorizontal();
        ob.reflectVertical();
        ob.move();
        
        
        
        Ball ball = new Ball(50, 50, 5, 10, 30);
        Container box = new Container(0, 0, 100, 100);
        for (int step = 0; step < 100; ++step) {
            ball.move();
            box.collidesWith(ball);
            System.out.println(ball); // manual check the position of the ball
        }

    }

}
