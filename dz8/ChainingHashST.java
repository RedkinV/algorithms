package ru.geekbrains.algorithms.lesson8;

public class ChainingHashST<Key,Value> {
    private int M=97;
    private int size=0;
    private Object [] st= new Object[M];

    private class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }

//    public ChainingHashST(){
//        st=(Node[])new Object[M];
//    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
    public void put (Key key, Value value){
        if (key==null) throw new IllegalArgumentException("Key can't be null");

        int i=hash(key);
        Node x=(Node) st[i];

        while(x!=null){
            if (key.equals(x.key)) {
                x.value=value;
                return;
            }
            x=x.next;
        }
        st[i]=(Object) new Node(key,value,(Node)st[i]);
        size++;

    }

    public Value get(Key key){

        if (key==null) throw new IllegalArgumentException("Key can't be null");

        int i=hash(key);
        Node x=(Node)st[i];

        while(x!=null){
            if (key.equals(x.key)) {
                return x.value;
            }
            x=x.next;
        }
        return null;
    }

    private int hash(Key key){
        return (key.hashCode()&0x7fffffff)%M;
    }
}
