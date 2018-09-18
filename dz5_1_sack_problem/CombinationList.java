package ru.geekbrains.algorithms.lesson5_1_sack_problem;

public class CombinationList {

    private class Combo {
        String str;
        int totaPrice;
        Combo next;
    }

    private Combo first = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first.next == null;
    }

    public void push(String comboString, int totalPrice) {
        Combo tmp = new Combo();

        tmp.str =comboString;
        tmp.totaPrice=totalPrice;
        tmp.next = first;
        first = tmp;
        size++;
    }

    public String getMaxTotalPrice (){
        Combo current=first;
        int max;

        if (current!=null) {
            max = first.totaPrice;
            while (current != null) {
                if (current.totaPrice > max) max = current.totaPrice;
                current = current.next;
            }
            current=first;
            while (current != null) {
                if (current.totaPrice ==max) return "Best combination-> "+current.str+" TotalPrice="+max;
                current = current.next;
            }
        }
        return "";
    }

    public void printList(){
        Combo cur=first;
        System.out.println("Valid combinations:");
        while (cur!=null){
            System.out.println(cur.str+" TP="+cur.totaPrice+";");
            cur=cur.next;
        }
    }

    @Override
    public String toString() {
        String s="";
        Combo cur=first;
        while (cur!=null){
            s=s+cur.str+" TP="+cur.totaPrice+"; ---  " ;
            cur=cur.next;
        }
        return s;
    }
}
