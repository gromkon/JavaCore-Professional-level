package Lesson3.Homework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task3 {

    private final static int COUNT_SYMBOLS_ON_PAGE = 1800;

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("src/main/java/Lesson3/Homework/task3-text.txt", "r");) {
            Scanner sc = new Scanner(System.in);
            int pageNumber;

            do {
                System.out.println("Введите номер страницы для чтения. Если хотите закончить, введите -1");
                pageNumber = sc.nextInt();

                if (pageNumber >= 1) {
                    try {
                        raf.seek((pageNumber - 1) * COUNT_SYMBOLS_ON_PAGE);
                        byte[] page = new byte[COUNT_SYMBOLS_ON_PAGE];

                        if (raf.read(page) != -1) {
                            System.out.println(new String(page, 0, COUNT_SYMBOLS_ON_PAGE, StandardCharsets.UTF_8));
                        } else {
                            System.out.println("Такой страницы нет. Последняя страница данного текста - 39");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (pageNumber != -1) {
                    System.out.println("Номер страницы должен быть больше 0");
                }

            } while (pageNumber != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
