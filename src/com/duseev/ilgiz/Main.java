package com.duseev.ilgiz;


public class Main {

    public static void main(String[] args) {
        Realization realiz=new Realization();
        realiz.filling();
        realiz.sort();
        realiz.print();
        realiz.fillingCronDates();
        realiz.printCronDates();
        System.out.println(realiz.convert());
        System.out.println(realiz.getImplementationInfo());


    }
}
