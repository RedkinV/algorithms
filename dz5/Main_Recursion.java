package ru.geekbrains.algorithms.lesson5;

public class Main_Recursion {

    public static void main(String[] args) {

        System.out.println("Умножение");
        System.out.println(product(2,50));
        System.out.println(recProduct(2,50));

        System.out.println();
        System.out.println("Степень");
        System.out.println(power(2,50));
        System.out.println(recPower(2,50));

        System.out.println();
        System.out.println("Сложение");
        System.out.println(sum(2,50));
        System.out.println(recSum(2,50));

    }

    public static long power(int a,int b){
        long c=1;
        for (int i = 0; i <b ; i++)  c=c*a;
        return c;
    }

    public static long recPower(int a,int b){
        if (b==0) return 1;
        else return a*recPower(a,(b-1));
    }

    public static int product(int a,int b){
        int c=0;
        for (int i = 0; i <b ; i++)  c=c+a;
        return c;
    }

    public static int recProduct(int a,int b){
        if (b==0) return 0;
        else return a+recProduct(a,(b-1));
    }

    public static int sum(int a,int b){

        for (int i = 0; i <b ; i++)  a++;
        return a;
    }

    public static int recSum(int a,int b){
        if (b==0) return a;
        else return recSum(a,(b-1))+1;
    }




}//end class
