package ru.geekbrains.algorithms.lesson5_1_sack_problem;

public class Cargo implements Comparable {
    private String name;
    private int weight;
    private int price;
    private int miss;

    public Cargo(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.miss = 0;
    }

    public int getMiss() {
        return miss;
    }

    public void setMiss(int miss) {
        this.miss = miss;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Cargo temp;
        temp = (Cargo) o;
        if (this.weight > temp.weight) return 1;
        else if (this.weight < temp.weight) return -1;
        else if (this.weight == temp.weight) return 0;

        return 0;
    }

    @Override
    public String toString() {
        return name + " (W:" + weight + "), ";

    }
}
