package com.duseev.ilgiz;

import java.util.LinkedList;

public class Realization {
    LinkedList<String> dates = new LinkedList<>();
    public void filling() {
    String date1="2000-01-30T19:53:00";
    String date2="2022-01-24T19:54:00";
    String date3="2022-01-24T19:55:00";
    String date4="2022-01-24T19:56:00";
    String date5="2022-01-24T19:57:00";
    String date6="2022-01-24T19:58:00";
    String date7="2022-01-24T19:59:00";
    String date8="2022-01-24T20:00:00";
    String date9="2022-01-24T20:01:00";
    String date10="2022-01-24T20:02:00";
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);
        dates.add(date4);
        dates.add(date5);
        dates.add(date6);
        dates.add(date7);
        dates.add(date8);
        dates.add(date9);
        dates.add(date10);
    }
    public void sort(){
        dates.sort(String::compareToIgnoreCase);
    }
    public void print() {
    for (String date : dates) {
        System.out.println(date);
    }
}
    public String Weekday(int day,int month, int year){
        int daycode = day;
        int monthcode;
        int yearcode;
        int century;
        int weekdaycode;
        if(month==2){
            monthcode=12;
        }
        else if(month==1){
            monthcode=11;
        }
        else{
            monthcode=month-2;
        }

        if((monthcode==11 || monthcode==12) && year%100==0){
            yearcode=99;
        }
        else if(monthcode==11 || monthcode==12){
            yearcode=(year%100)-1;
        }
        else{
            yearcode=year%100;
        }

        if((monthcode==11 || monthcode==12) && year%100==0){
            century=(year/100)-1;
        }
        else{
            century=year/100;
        }
        weekdaycode=(daycode+((13*monthcode-1)/5)+yearcode+(yearcode/4)+(century/4)-(2*century))%7;
        String weekday="";
        if(weekdaycode==0){
            weekday = "SUN";
        }
        else if(weekdaycode==1){
            weekday = "MON";
        }
        else if(weekdaycode==2){
            weekday = "TUE";
        }
        else if(weekdaycode==3){
            weekday = "WED";
        }
        else if(weekdaycode==4){
            weekday = "THU";
        }
        else if(weekdaycode==5){
            weekday = "FRI";
        }
        else if(weekdaycode==6){
            weekday = "SAT";
        }
     return weekday;
    }
    LinkedList<CronDate> cronDates = new LinkedList<>();
    public void fillingCronDates() {
        for (String date: dates) {
            CronDate crondate1 = new CronDate();
            crondate1.seconds = Integer.parseInt(date.substring(17,19).trim());
            crondate1.minutes = Integer.parseInt(date.substring(14, 16).trim());
            crondate1.hour = Integer.parseInt(date.substring(11, 13).trim());
            crondate1.day = Integer.parseInt(date.substring(8, 10).trim());
            crondate1.month = Integer.parseInt(date.substring(5, 7).trim());
            crondate1.year = Integer.parseInt(date.substring(0, 4).trim());
            crondate1.weekday = Weekday(crondate1.day, crondate1.month, crondate1.year);
            cronDates.add(crondate1);
        }
    }
    public void printCronDates() {
        for (int i=0;i<10;i++) {
            System.out.println(cronDates.get(i));
        }
    }
    public void convert(){
        int []countweekday=new int[7];
        int []countmonth=new int[12];
        int []countday=new int[31];
        int []counthour=new int[23];
        int []countminutes=new int[59];
        int []countwseconds=new int[59];





    }
    public String getImplementationInfo;
}
