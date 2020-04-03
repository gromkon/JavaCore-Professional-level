package Lesson5.Homework;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        // Подготовка
        // CARS_COUNT + 1, т.к. CARS_COUNT - количество машин, а "1" - это для сообщения о готовности
        CountDownLatch waitingPreparation = new CountDownLatch(CARS_COUNT + 1);

        // Окончание
        CountDownLatch waitingFinished = new CountDownLatch(CARS_COUNT);

        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));

        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), waitingPreparation, waitingFinished);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        // Ожидание начала гонки
        try {
            // Когда все машины готовы, выводится объявление о начале гонке, и машинам разрешается начать гонку
            while (true) {
                if (waitingPreparation.getCount() == 1) {
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                    waitingPreparation.countDown();
                    break;
                }
            }
            waitingPreparation.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ожидание окончания гонки
        try {
            waitingFinished.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}





