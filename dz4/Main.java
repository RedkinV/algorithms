package ru.geekbrains.algorithms.lesson4;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> mll=new MyLinkedList<>();

        mll.insert(3,0);
        mll.insertFirst(4);
        mll.insertLast(15);
        System.out.println(mll);
        mll.insert(23,1);
        System.out.println(mll);
        System.out.println(mll.getFirst());
        System.out.println(mll.getLast());

        mll.removeFirst();
        System.out.println(mll);
        mll.removeLast();
        System.out.println(mll);
        mll.remove(23);
        System.out.println(mll);

        System.out.println("Stack----------------");
        MyLinkedListStack<Integer> stack =new MyLinkedListStack<>();
        stack.push(3);
        stack.push(5);
        stack.push(6);
        System.out.println("peek- "+stack.peek());
        System.out.println("pop- "+stack.pop());
        System.out.println("peek- "+stack.peek());

        System.out.println("Queue----------------");
        MyLinkedListQueue<Integer> q =new MyLinkedListQueue<>();
        q.enqueue(3);
        q.enqueue(6);
        q.enqueue(38);
        System.out.println("peek- "+q.peek());
        System.out.println("dequeue- "+q.dequeueu());
        System.out.println("dequeue- "+q.dequeueu());
        System.out.println("peek- "+q.peek());


    }
}
