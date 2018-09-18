package ru.geekbrains.algorithms.lesson4;

import java.util.Iterator;

public class MyLinkedList<Item> implements Iterable<Item> {
    @Override
    public Iterator<Item> iterator() {
        return null;
    }


    class MyLinkedListIterator implements Iterator{
        Node current;

        public MyLinkedListIterator() {//додумывал сам. делал так, чтобы итератор стоял как бы перед первым элементом. Угада?
            this.current.next = first;
        }

        @Override
        public boolean hasNext() {
            return current.next!=null;
        }

        @Override
        public Object next() {// то что тут стоит Object не помешает???
            if (hasNext()) {
                current=current.next;
                return current;
            }
            return null;
        }
    }
    class Node{
        Item item;
        Node next;
        Node prev;
    }

    private Node first=null;
    private Node last=null;
    private int size=0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first.next==null;
    }

    public void insert(Item item, int pos){
        if (size==0) {
            insertFirst(item);
        } else if (pos==size){
            insertLast(item);
        } else if(pos>size||pos<0){
            throw new IndexOutOfBoundsException();
        } else {
            Node tmp=new Node();
            tmp.item=item;
            Node current=first;
            int i=0;
            while (i<pos){
                current=current.next;
                i++;
            }
            Node before=current.prev;
            tmp.prev=before;
            tmp.next=current;
            before.next=tmp;
            current.prev=tmp;
            size++;
        }
    }

    public Item getFirst() {
        return first.item;
    }

    public Item getLast(){
        return last.item;
    }

    public void insertFirst(Item item){
        Node tmp=new Node();
        tmp.item=item;
        tmp.next=first;
        tmp.prev=null;
        if (size>0) first.prev=tmp;
        first=tmp;
        if(size==0) last=tmp;
        size++;
    }
    public void insertLast(Item item){
        Node tmp=new Node();
        tmp.item=item;
        if (size>0) {
            last.next = tmp;
            tmp.prev=last;
        }
        last=tmp;
        if (size==0) first=tmp;
        size++;

    }

    public Item removeFirst(){
        if(size==0) return null;
        else {
            Item tmp=first.item;
            first=first.next;
            first.prev=null;
            size--;
            return tmp;
        }
    }

    public Item removeLast(){
        if(size==0) return null;
        else {
            Node beforeLast=last.prev;
            Item tmp=last.item;
            last.prev=null;
            beforeLast.next=null;
            last=beforeLast;
            size--;
            return tmp;
        }
    }
    public Item remove(Item item){
        if (isEmpty()) return null;
        else {
            Node current = first;
            while(current!=null) {
                if(current.item.equals(item)) {
                    if (current==first) {
                        removeFirst();
                        return item;
                    } else if(current==last) {
                        removeLast();
                        return item;
                    }else {
                        Node beforeCur = current.prev;
                        Node afterCur = current.next;
                        beforeCur.next = afterCur;
                        afterCur.prev = beforeCur;
                        current.next = null;
                        current.prev = null;
                        size--;
                        return current.item; // а так можно , или надо возвращать переменную temp равную current.item?
                    }
                }
                current = current.next;
            }
            return null;
        }
    }

    @Override
    public String toString() {
        String s="";
        Node cur=first;
        while (cur!=null){
            s=s+cur.item.toString()+" ";
            cur=cur.next;
        }
        return s;
    }


}//end class
