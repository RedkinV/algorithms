package ru.geekbrains.algorithms.lesson4;

public class MyLinkedListQueue<Item> {
    MyLinkedList<Item> queue=new MyLinkedList<>();

    public void enqueue(Item item){
        queue.insertLast(item);
    }
    public Item dequeueu(){
        return queue.removeFirst();
    }
    public Item peek(){
        return queue.getFirst();
    }

    public int size(){
        return queue.size();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
