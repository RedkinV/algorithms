package ru.geekbrains.algorithms.lesson8;

public class LinearProbingHashST<Key, Value> {
    private int M=100;
    private int size=0;
    private Key[] keys=(Key[]) new Object[M];
    private Value[] values=(Value[]) new Object[M];

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private int hash(Key key){
        return (key.hashCode()&0x7fffffff)%M;
    }

    public void put (Key key, Value value){
        if (key==null) throw new IllegalArgumentException("Key can't be null");

        int i;
        for (i = hash(key); keys[i]!=null ; i=(i+1)%M) {
            if (keys[i].equals(key)) {
                values[i]=value;
                return;
            }
        }
        keys[i]=key;
        values[i]=value;
        size++;
    }

    public Value get(Key key){

        if (key==null) throw new IllegalArgumentException("Key can't be null");

        int i;
        for (i = hash(key); keys[i]!=null ; i=(i+1)%M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;

    }
}
