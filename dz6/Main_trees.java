package ru.geekbrains.algorithms.lesson6_trees;

import java.util.Random;

public class Main_trees {
    public static void main(String[] args) {
        BST<Integer, String>[] bst = new BST[6];
        Random random = new Random();
        int balancedTree=0;
        double averDepth;


        for (int i = 0; i < 6; i++) {
            bst[i]=new BST<>();
            do {
                bst[i].put(random.nextInt(100) - 100, "A");
            } while (bst[i].depth() < 6);

            averDepth=Math.log(bst[i].size())/Math.log(2);
            if (averDepth==bst[i].depth()) balancedTree++;

            System.out.printf("Кол-во элементов дерева=%-4d  Глубина дерева=%-4d Целевая глубина=%-20f",bst[i].size(),bst[i].depth(),averDepth);
            System.out.println();
        }
        System.out.println();
        System.out.println("кол-во сбалансированных деревьев="+balancedTree);
    }

}
