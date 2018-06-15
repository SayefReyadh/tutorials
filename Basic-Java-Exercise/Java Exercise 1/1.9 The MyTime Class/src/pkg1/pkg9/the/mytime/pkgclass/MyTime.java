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
public class MyTime {

    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        if ((hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59) && (second >= 0 && second <= 59)) {
            return;
        } else {
            throw new IllegalArgumentException("Invalid hour, minute, or second!");
        }

    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "" + hour + ":" + minute + ":" + second + "";
    }

    public MyTime nextSecond() {
        this.second++;
        if (this.second > 59) {
            this.second = 0;
            this.minute++;
        }
        if (this.minute > 59) {
            this.minute = 0;
            this.hour++;
        }
        if (this.hour > 23) {
            this.hour = 0;
        }
        return new MyTime(this.hour, this.minute, this.second);
    }

    public MyTime nextMinute() {

        this.minute++;

        if (this.minute > 59) {
            this.minute = 0;
            this.hour++;
        }
        if (this.hour > 23) {
            this.hour = 0;
        }
        return new MyTime(this.hour, this.minute, this.second);
    }

    public MyTime nextHour() {

        this.hour++;
        if (this.hour > 23) {
            this.hour = 0;
        }
        return new MyTime(this.hour, this.minute, this.second);
    }

    public MyTime previousSecond() {

        this.second--;
        if (this.second < 0) {
            this.second = 59;
            this.minute--;
        }
        if (this.minute < 0) {
            this.minute = 59;
            this.hour--;
        }
        if (this.hour < 0) {
            this.hour = 23;
        }
        return new MyTime(this.hour, this.minute, this.second);
    }

    public MyTime previousMinute() {

        this.minute--;

        if (this.minute < 0) {
            this.minute = 59;
            this.hour--;
        }
        if (this.hour < 0) {
            this.hour = 23;
        }
        return new MyTime(this.hour, this.minute, this.second);
    }

    public MyTime previousHour() {

        this.hour--;
        
        if (this.hour < 0) {
            this.hour = 23;
        }
        return new MyTime(this.hour, this.minute, this.second);
    }

}
