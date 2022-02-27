package com.duseev.ilgiz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Realization {
    LinkedList<String> dates = new LinkedList<>();
    public void filling() {
    String date1="2022-01-25T08:00:00";
    String date2="2022-01-25T08:30:00";
    String date3="2022-01-25T09:00:00";
    String date4="2022-01-25T09:30:00";
    String date5="2022-01-26T08:00:00";
    String date6="2022-01-26T08:30:00";
    String date7="2022-01-26T09:00:00";
    String date8="2022-01-26T09:30:00";
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);
        dates.add(date4);
        dates.add(date5);
        dates.add(date6);
        dates.add(date7);
        dates.add(date8);
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
        int ListSize=cronDates.size();
        for (int i=0;i<ListSize;i++) {
            System.out.println(cronDates.get(i));
        }
    }
    public void convert(){
        int []countweekday=new int[7];
        int []countmonth=new int[13];
        int []countday=new int[32];
        int []counthour=new int[24];
        int []countminutes =new int[60];
        int []countseconds=new int[60];
        String valuemaxSecondsCount="*";
        String valuemaxMinutesCount="*";
        String valuemaxHourCount="*";
        String valuemaxDayCount="*";
        String valuemaxMonthCount="*";
        String valuemaxWeekdayCount="*";
        int maxSecondsCount;
        int maxMinutesCount;
        int maxHourCount;
        int maxDayCount;
        int maxMonthCount;
        int maxWeekdayCount;
        int ListSize=cronDates.size();
        for(int i=0;i<ListSize;i++){
            countseconds[cronDates.get(i).seconds]++;
        }
        IntStream intStream = Arrays.stream(countseconds);
        OptionalInt optionalInt = intStream.max();
        maxSecondsCount = optionalInt.getAsInt();

        if(maxSecondsCount > ListSize/2){
            for(int i=0;i<59;i++){
                if(countseconds[i]==maxSecondsCount){
                    valuemaxSecondsCount = "" + i;
                }
            }
            for(int i=0;i<ListSize;i++){
                if(cronDates.get(i).seconds==Integer.parseInt(valuemaxSecondsCount.trim())){
                    countminutes[cronDates.get(i).minutes]++;
                }
            }
            intStream = Arrays.stream(countminutes);
            optionalInt = intStream.max();
            maxMinutesCount = optionalInt.getAsInt();
            if(maxMinutesCount>ListSize/2){
                for(int i=0;i<59;i++){
                    if(countminutes[i]==maxMinutesCount){
                        valuemaxMinutesCount = "" + i;
                    }
                }
                //код для этого случая
            }
            else {
                for(int i=0;i<ListSize;i++){
                    if(cronDates.get(i).seconds==Integer.parseInt(valuemaxSecondsCount.trim())){
                        counthour[cronDates.get(i).hour]++;
                    }
                }
                intStream = Arrays.stream(counthour);
                optionalInt = intStream.max();
                maxHourCount = optionalInt.getAsInt();
                if(maxHourCount > ListSize/2){
                    for(int i=0;i<23;i++){
                        if(counthour[i]==maxHourCount){
                            valuemaxHourCount = "" + i;
                        }
                    }
                    for(int i=0;i<ListSize;i++){
                        if(cronDates.get(i).hour==Integer.parseInt(valuemaxHourCount.trim())){
                            countday[cronDates.get(i).day]++;
                        }
                    }
                    intStream = Arrays.stream(countday);
                    optionalInt = intStream.max();
                    maxDayCount = optionalInt.getAsInt();
                    if(maxDayCount>ListSize/2){
                        for(int i=0;i<32;i++){
                            if(countday[i]==maxDayCount){
                                valuemaxDayCount = "" + i;
                            }
                        }
                        for(int i=0;i<ListSize;i++){
                            if(cronDates.get(i).day==Integer.parseInt(valuemaxDayCount.trim())){
                                countmonth[cronDates.get(i).month]++;
                            }
                        }
                        intStream = Arrays.stream(countmonth);
                        optionalInt = intStream.max();
                        maxMonthCount = optionalInt.getAsInt();
                        if(maxMonthCount>ListSize/2){
                            for(int i=0;i<13;i++){
                                if(countmonth[i]==maxMonthCount){
                                    valuemaxMonthCount = "" + i;
                                }
                            }
                        }
                    }
                    else{
                        valuemaxDayCount = "*";
                        //код для этого случая

                    }
                }
                else {
                    valuemaxHourCount = "*";
                    //код для этого случая

                }
            }
        }


        String result=valuemaxSecondsCount + " " + valuemaxMinutesCount + " " + valuemaxHourCount+ " " +valuemaxDayCount+ " " +valuemaxMonthCount+ " " +valuemaxWeekdayCount;
        System.out.println(result);
    }
    public String getImplementationInfo;
}
