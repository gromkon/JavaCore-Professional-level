package Lesson5.Homework;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    // Контролирует количество машин внутри туннеля
    private Semaphore controlCountCarsInside;

    public Tunnel(int size) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        controlCountCarsInside = new Semaphore(size);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                // Увеличиваем количество машин внутри
                controlCountCarsInside.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                // Уменьшаем количество машин внутри
                controlCountCarsInside.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
