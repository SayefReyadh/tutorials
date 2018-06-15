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
public class MyDate {

    private int year;
    private int month;
    private int day;
    private static String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isValidDate(int year, int month, int day) {

        if (year >= 1 && year <= 9999) {
            if (month >= 1 && month <= 12) {
                if (day <= daysInMonths[month - 1]) {
                    return true;
                } else if (day == 29 && isLeapYear(year)) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public static int getDayOfWeek(int year, int month, int day) {

        int y = 0, m = 0, d = 0, c = 0, leap = 0;
        int reminder = 0;
        int sum = 0;

        int yearCheck[][] = {{1, 7, 18, 24, 29, 35, 46, 52, 57, 63, 74, 80, 85, 91}, {2, 8, 13, 19, 30, 36, 41, 47, 58, 64, 69, 75, 86, 92, 97}, {3, 14, 20, 25, 31, 42, 48, 53, 59, 70, 76, 81, 87, 98}, {10, 16, 21, 27, 38, 44, 49, 55, 66, 72, 77, 83, 94, 00}, {5, 11, 22, 28, 33, 39, 50, 56, 61, 67, 78, 84, 89, 95}, {6, 12, 17, 23, 34, 40, 45, 51, 62, 68, 73, 79, 90, 96}};
        int monthCheck[][] = {{4, 7}, {1, 10}, {5}, {8}, {2, 3, 11}, {6}, {7, 12}};
        int dayCheck[][] = {{7, 14, 21, 28}, {1, 8, 15, 22, 29}, {2, 9, 16, 23, 30}, {3, 10, 17, 24, 31}, {4, 11, 18, 25}, {5, 12, 19, 26}, {06, 13, 20, 27}};
        int centuryCheck[] = {0, 0, 3, 0, 2, 0, 1};
        if (isLeapYear(year) && month != 0 && month != 1);
        {
            leap = 1;
        }
        int i, j;
        for (i = 0; i < dayCheck.length; i++) {
            for (j = 0; j < dayCheck[i].length; j++) {
                if (day == dayCheck[i][j]) {
                    d = i;
                    //System.out.println("d is " + d);
                    break;
                }
            }
        }
        for (i = 0; i < monthCheck.length; i++) {
            for (j = 0; j < monthCheck[i].length; j++) {
                if (month == monthCheck[i][j]) {
                    m = i;

                    //System.out.println("m is " + m);
                    break;
                }
            }
        }
        for (i = 0; i < yearCheck.length; i++) {
            for (j = 0; j < yearCheck[i].length; j++) {
                if (year % 100 == yearCheck[i][j]) {
                    y = i;

                    //System.out.println("y is " + y);
                    break;
                }
            }
        }

        reminder = year / 100 + 1;
        reminder = reminder / 4;

        for (i = 0; i < centuryCheck.length; i++) {
            if (reminder == centuryCheck[i]) {
                c = i;

                //System.out.println("c is " + c);
                break;
            }
        }

        sum = (d + m + y + c + leap) % 7;

        //System.out.println("sum is " + sum);
        return sum;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        if (!isValidDate(this.year, this.month, this.day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        
    }

    public void setDate(int year, int month, int day) {

        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        if (year >= 1 && year <= 9999) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid year!");
        }
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month!");
        }

    }

    public void setDay(int day) {
        if (day <= daysInMonths[this.month - 1]) {
            this.day = day;
        } else if (day == 29 && isLeapYear(this.year)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid day!");
        }

    }

    MyDate nextDay() {
        this.day++;
        if (!isLeapYear(this.year)) {
            if (day > daysInMonths[this.month - 1]) {
                this.day = 1;
                this.month++;
            }
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            }
        } else if (isLeapYear(this.year)) {
            if (this.month == 2) {
                if (this.day == 30) {
                    this.day = 1;
                    this.month++;
                }
                if (this.month > 12) {
                    this.month = 1;
                    this.year++;
                }
            } else if (day > daysInMonths[this.month - 1]) {
                this.day = 1;
                this.month++;
            }
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            }
        }

        return this;
    }

    MyDate nextMonth() {
        this.month++;
        if (this.day > daysInMonths[month]) {
            this.day = daysInMonths[month];
        }
        if (this.month > 12) {
            this.month = 1;
            this.year++;
        }

        return this;
    }

    MyDate nextYear() {
        if (isLeapYear(this.year)) {
            this.year++;
            if (this.day == 29 && this.month == 2) {
                this.day = 28;

            }
        } else {
            this.year++;
        }
        return this;
    }

    MyDate previousDay() {
        this.day--;
        if (this.day == 0) {
            this.month--;
            if (this.month == 0) {
                this.month = 12;
                this.year--;
            }
            this.day = MyDate.daysInMonths[this.month - 1];
        }

        return this;
    }

    MyDate previousMonth() {
        if (this.day == MyDate.daysInMonths[this.month - 1]) {
            if (this.month > 1) {
                this.day = MyDate.daysInMonths[this.month - 2];
            } else {
                this.day = MyDate.daysInMonths[this.month + 12 - 2];
            }
        }
        this.month--;
        if (this.month < 0) {
            this.month = 12;
            this.year--;
        }
        return this;
    }

    MyDate previousYear() {
        if (isLeapYear(this.year)) {
            this.year--;
            if (this.day == 29 && this.month == 2) {
                this.day = 28;

            }
        } else {
            this.year--;
        }

        return this;
    }

    @Override
    public String toString() {
        return strDays[getDayOfWeek(this.year, this.month, this.day)] + " " + this.day + " " + MyDate.strMonths[this.month - 1] + " " + this.year;

    }

}
