package Lesson4.Homework;

public class ABC {

    private final Object monitor = new Object();
    private String letter = "A";

    private void print(String current, String next) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (!letter.equals(current)) {
                        monitor.wait();
                    }

                    System.out.print(current);
                    letter = next;

                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ABC abc = new ABC();

        Thread t1 = new Thread(() -> {
            abc.print("A", "B");
        });
        Thread t2 = new Thread(() -> {
            abc.print("B", "C");
        });
        Thread t3 = new Thread(() -> {
            abc.print("C", "A");
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
