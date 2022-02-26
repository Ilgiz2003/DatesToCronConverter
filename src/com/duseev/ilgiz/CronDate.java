package com.duseev.ilgiz;

public class CronDate {
    public int seconds;
    public int minutes;
    public int hour;
    public int day;
    public int month;
    public int year;
    public String weekday;

    @Override
    public String toString() {
        return seconds + " " + minutes +" " + hour + " " + day +" " + month + " " + year +" " + weekday;
    }
}
