package Lesson5.Homework;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private static String FINISHED_CAR;

    static {
        CARS_COUNT = 0;
        FINISHED_CAR = null;
    }

    private Race race;
    private int speed;
    private String name;

    private CountDownLatch waitingPreparation;
    private CountDownLatch waitingFinished;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch waitingPreparation, CountDownLatch waitingFinished) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.waitingPreparation = waitingPreparation;
        this.waitingFinished = waitingFinished;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            waitingPreparation.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ожидание подготовки всех машин
        try {
            waitingPreparation.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        // Определение победителя
        if (FINISHED_CAR == null) {
            FINISHED_CAR = this.name;
            System.out.println(FINISHED_CAR + " - WIN");
        }

        // Ожидание финиширования всех машин
        waitingFinished.countDown();


    }

}
