/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.pkg9.the.mytime.pkgclass;

/**
 *
 * @author SayefReyadh
 */
public class TestMyTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyTime time = new MyTime(22,58,59);        
        System.out.println(time.toString());
        time.nextSecond();
        time.nextMinute();
        time.nextHour();
        System.out.println(time.toString());
        time.previousSecond();
        time.previousMinute();
        time.previousHour();
        System.out.println(time.toString());
        
        System.out.println(time.getHour()+ " " +time.getMinute()+ " " +time.getSecond());
        
        time.setHour(0);
        time.setMinute(0);
        time.setSecond(0);
    }
    
}
