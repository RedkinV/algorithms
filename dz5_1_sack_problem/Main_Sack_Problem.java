package ru.geekbrains.algorithms.lesson5_1_sack_problem;

public class Main_Sack_Problem {


    public static String findCombination(CargoArray ca, Sack sack, CombinationList cl){
        String s="";

        if (sack.tryToLoad(ca)) cl.push(ca.toString(),ca.totalPrice());
        else {
            for (int i = 0; i <ca.getSize() ; i++) {
                if (ca.getCargoPos(i).getMiss()!=1) {
                    ca.getCargoPos(i).setMiss(1);
                    if(findCombination(ca, sack, cl)!="") cl.push(ca.toString(),ca.totalPrice());
                    ca.getCargoPos(i).setMiss(0);
                }
            }
        }
        return s;
    }




    public static void main(String[] args) {

        CargoArray cArr=new CargoArray();
        CombinationList combinationList=new CombinationList();

        cArr.addItem(new Cargo("a",5,34));
        cArr.addItem(new Cargo("b",2,5));
        cArr.addItem(new Cargo("c",3,6));
        cArr.addItem(new Cargo("d",6,7));
        cArr.addItem(new Cargo("e",1,23));

        Sack sack=new Sack(4);

        findCombination(cArr,sack, combinationList);//заполняет список комбинация , вес которых меньше либо равен размеру рюкзака
        System.out.println(combinationList.getMaxTotalPrice()); // выбирает комбинацию с наибольшей "стоимостью"



    }
}
