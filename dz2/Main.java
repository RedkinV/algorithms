package ru.geekbrains.algorithms.lesson2;
import java.util.Random;

public class Main {



    public static void main(String[] args) {
        ArraySorted<Integer> myArr=new ArraySorted<>();
        int size=1000000;
        Random r=new Random();

//insert
        for (int i = 0; i < size; i++) {
            myArr.addItem(r.nextInt(size*10));
        }

        long startTime = System.nanoTime();
        myArr.insertSort();
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime)/1000;
        System.out.println("ins sort Time: "+totalTime);
//buble
        for (int i = 0; i < size; i++) {
            myArr.addItem(r.nextInt(size*10));
        }

        startTime = System.nanoTime();
        myArr.bubleSort();
        endTime   = System.nanoTime();
        totalTime = (endTime - startTime)/1000;
        System.out.println("bub sort Time: "+totalTime);
//selection
        for (int i = 0; i < size; i++) {
            myArr.addItem(r.nextInt(size*10));
        }

        startTime = System.nanoTime();
        myArr.selectSort();
        endTime   = System.nanoTime();
        totalTime = (endTime - startTime)/1000;
        System.out.println("sel sort Time: "+totalTime);

    }
}
