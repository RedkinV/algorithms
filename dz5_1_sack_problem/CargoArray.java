package ru.geekbrains.algorithms.lesson5_1_sack_problem;

public class CargoArray {
    private Cargo[] item;
    private int size;

    public CargoArray() {
        this.item = new Cargo[1];
        this.size = 0;
    }

    public int totalWeight(){
        int tmp=0;
        for (int i = 0; i < size; i++) {
            if (item[i].getMiss()!=1) {
                tmp+=item[i].getWeight();
            }
        }
        return  tmp;
    }

    public int totalPrice(){
        int tmp=0;
        for (int i = 0; i < size; i++) {
            if (item[i].getMiss()!=1) {
                tmp+=item[i].getPrice();
            }
        }
        return  tmp;
    }


    public int getSize(){
        return size;
    }

    private void resize(){
        Cargo[] temp=new Cargo[size*2];

        for (int i = 0; i <size; i++) {
            temp[i]=item[i];
        }
        item=temp;
    }

    public void addItem(Cargo it){
        if(size==item.length) resize();
        this.item[size] = it; // можно оптимизировать ++size
        size++;
    }



    public Cargo getCargoPos(int pos) {
        return item[pos];
    }

    @Override
    public String toString() {
        String s="";
        for (int i = 0; i <size ; i++) {
            if (item[i].getMiss()!=1) s+=item[i].toString();
        }
        return s;
    }

}
