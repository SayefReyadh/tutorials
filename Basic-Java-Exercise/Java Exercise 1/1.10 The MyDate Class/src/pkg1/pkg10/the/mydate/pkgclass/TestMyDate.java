/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.pkg10.the.mydate.pkgclass;

/**
 *
 * @author SayefReyadh
 */
public class TestMyDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println(MyDate.isValidDate(2012, 2, 28));
        MyDate d1 = new MyDate(2012, 2, 28);
        
        /// getDayOfWeek method is not working one day is shifting
        /// http://www.wikihow.com/Know-the-Day-of-the-Week-for-Any-Day-of-Any-Year
        
        //System.out.println(MyDate.getDayOfWeek(2012, 3, 1));
        
        System.out.println(d1); // Tuesday 28 Feb 2012
        System.out.println(d1.nextDay()); // Wednesday 29 Feb 2012
        System.out.println(d1.nextDay()); // Thursday 1 Mar 2012
        System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012
        System.out.println(d1.nextYear()); // Monday 1 Apr 2013
        MyDate d2 = new MyDate(2012, 1, 2);
        System.out.println(d2); // Monday 2 Jan 2012
        System.out.println(d2.previousDay()); // Sunday 1 Jan 2012
        System.out.println(d2.previousDay()); // Saturday 31 Dec 2011
        System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011
        System.out.println(d2.previousYear()); // Tuesday 30 Nov 2010
        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear()); // Monday 28 Feb 2011
        //MyDate d4 = new MyDate(2099, 11, 31); // Invalid year, month, or day!
        //MyDate d5 = new MyDate(2011, 2, 29); // Invalid year, month, or day!
    }

}
