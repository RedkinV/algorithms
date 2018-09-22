package ru.geekbrains.algorithms.lesson5_1_sack_problem;

public class Sack {
    private int capacity;

    public Sack(int capacity) {
        this.capacity = capacity;
    }

    public boolean tryToLoad(CargoArray carr){
        int tmp=0;
        for (int i = 0; i <carr.getSize() ; i++) {
        if (carr.getCargoPos(i).getMiss()!=1) tmp+=carr.getCargoPos(i).getWeight();
        }

        if (tmp>capacity) return false;
        else              return true;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
