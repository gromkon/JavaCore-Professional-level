package Lesson1.Homework;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box;

    public Box(ArrayList<T> box) {
        this.box = box;
    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        if (!box.isEmpty()) {
            float weightOneFruit = box.get(0).getWeight();
            return weightOneFruit * box.size();
        } else {
            return 0.0f;
        }
    }

    public boolean compare(Box<?> anotherBox) {
        return this.getWeight() - anotherBox.getWeight() == 0.0f;
    }

    public void pour(Box<T> anotherBox) {
        for (T fruit : box) {
            anotherBox.addFruit(fruit);
        }
        box.clear();
    }

    public static void main(String[] args) {
        //1 коробка с яблоками
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();

        ArrayList<Apple> appleArrayList = new ArrayList<>();
        appleArrayList.add(apple1);
        appleArrayList.add(apple2);
        appleArrayList.add(apple3);
        appleArrayList.add(apple4);

        Box<Apple> boxApple1 = new Box<>(appleArrayList);
        System.out.println("Вес первой коробки с яблоками: " + boxApple1.getWeight());

        //коробка с апельсинами
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        ArrayList<Orange> orangeArrayList = new ArrayList<>();
        orangeArrayList.add(orange1);
        orangeArrayList.add(orange2);
        orangeArrayList.add(orange3);
        orangeArrayList.add(orange4);

        Box<Orange> orangeBox1 = new Box<>(orangeArrayList);
        System.out.println("Вес первой коробки с апельсинами: " + orangeBox1.getWeight());

        //вторая коробка с яблоками
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();

        ArrayList<Apple> appleArrayList2 = new ArrayList<>();
        appleArrayList2.add(apple5);
        appleArrayList2.add(apple6);

        Box<Apple> boxApple2 = new Box<>(appleArrayList2);
        System.out.println("Вес второй коробки с яблоками: " + boxApple2.getWeight());

        System.out.println("Первая коробка с яблоками равна по весу первой коробке с апельсинами? " + boxApple1.compare(orangeBox1));

        System.out.println("\nПересыпаем яблоки из первой коробки с яблоками во вторую коробку с яблоками");
        boxApple1.pour(boxApple2);
        System.out.println("Вес первой коробки с яблоками: " + boxApple1.getWeight());
        System.out.println("Вес второй коробки с яблоками: " + boxApple2.getWeight());
        System.out.println("Вторая коробка с яблоками равна по весу первой коробке с апельсинами? " + boxApple2.compare(orangeBox1));


    }

}


