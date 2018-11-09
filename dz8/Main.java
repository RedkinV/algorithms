package ru.geekbrains.algorithms.lesson8;

public class Main {

    public static void main(String[] args) {
        ChainingHashST<Integer, String> ch=new ChainingHashST<>();
        LinearProbingHashST<Integer, String> lp=new LinearProbingHashST<>();
        QuadraticProbingHashST<Integer, String> qp=new QuadraticProbingHashST<>();


//        qp.put(1,"A");
//        qp.put(3,"A");
//        qp.put(7,"A");
//        qp.put(23,"A");
//        qp.put(54,"A");
//        qp.put(78,"A");
//        qp.put(1,"AA");
//        System.out.println(qp.size());
//        System.out.println(qp.get(2));
//        System.out.println(qp.get(1));

        ch.put(5,"A");
        ch.put(2,"D");
        ch.put(6,"C");
        ch.put(78,"S");
        ch.put(12,"H");
        ch.put(5,"AA");

        System.out.println(ch.size());
        System.out.println(ch.get(78));
        System.out.println(ch.get(5));


//        lp.put(2,"A");
//        lp.put(4,"d");
//        lp.put(6,"F");
//        lp.put(8,"G");
//        lp.put(67,"SD");
//        lp.put(2,"AA");
//
//        System.out.println(lp.size());
//        System.out.println(lp.get(2));
//        System.out.println(lp.get(8));


    }
}
