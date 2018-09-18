package ru.geekbrains.algorithms.lesson4;

public class MyLinkedListStack<Item>  {
    MyLinkedList<Item> stack=new MyLinkedList<>();

    public void push(Item item){
        stack.insertFirst(item);
    }
    public Item pop(){
        return stack.removeFirst();
    }
    public Item peek(){
        return stack.getFirst();
    }

    public int size(){
        return stack.size();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
