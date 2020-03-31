package Lesson3.Homework;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task1 {
    public static void main(String[] args) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/main/java/Lesson3/Homework/task1.txt"));) {
            byte[] arr = new byte[50];
            int x;
            while ((x = in.read(arr)) != -1) {
                System.out.println(new String(arr, 0, x, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
