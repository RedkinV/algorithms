package ru.geekbrains.algorithms.lesson2;

import java.util.Random;

public class ArraySorted <Item extends Comparable<Item>>{
    private Object[] item;
    private int size;

    public ArraySorted () {
        this.item = new Object[1];
        this.size = 0;
    }

    private void resize(){
        Object[] temp=new Object[size*2];

        for (int i = 0; i <size; i++) {
        temp[i]=item[i];
        }
        item=temp;
    }
    private boolean exch(int x,int y){
        Object temp;
    if (x>=0 && x<size && y>=0 && y<size) {
        temp = item[x];
        item[x] = item[y];
        item[y] = temp;
        return true;
    } else return false;
    }

    public void addItem(Item it){
        if(size==item.length) resize();
        this.item[size] = it; // можно оптимизировать ++size
        size++;

    }

    public boolean deleteItem(Item it){
       int i;
       if(findItem(it)) {
           for (i = 0; i < size; i++) {
               if (item[i].equals(it)) break;
           }
           for (int j = i; j < size - 1; j++) {
               item[j] = item[j + 1];
           }
           size--;
           return true;
       } else  return false;
    }

    public boolean findItem(Item it) {
        for (int i = 0; i <size ; i++) {
            if (item[i].equals(it)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s="";
        for (int i = 0; i <size ; i++) {
            s=s+item[i]+", ";
        }
        return s;
    }

    private boolean isLess(int x, int y){
        Item xx=(Item)item[x];
        if (xx.compareTo((Item) item[y]) <0) return true;// x<y
        else return false;//x>y
    }
    public void bubleSort(){

        for (int j = size; j >0 ; j--) {
            for (int i = 0; i < j-1; i++) {
                if (isLess(i+1,i)) exch(i, i + 1);
            }
        }
    }

    public void selectSort(){
        int marker;
        Item a;

        for (int j = 0; j <size-1 ; j++) {
            marker=j;
            for (int i = j+1; i < size; i++) {
                if (isLess(i,marker)) marker = i;
            }
            exch(j,marker);
        }
    }

    public void insertSort(){
        int mark;
        for (int i = 1; i <size ; i++) {
            mark=i;
            for (int j = 0; j <i ; j++) {
                if( isLess(mark,j)) exch(mark,j);
            }
        }
    }

//    public long sortRunTime(char c, int size){
//        Random r=new Random();
//
//        for (int i = 0; i < size; i++) {
//            this.addItem((Item)r.nextInt(size));
//        }
//        long startTime = System.nanoTime();
//        this.insertSort();
//        long endTime   = System.nanoTime();
//
//        return (endTime - startTime)/1000;
//    }

} //end class


