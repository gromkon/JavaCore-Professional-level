package Lesson3.Homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Task2 {
    public static void main(String[] args) {
        try {
            ArrayList<InputStream> ali = new ArrayList<>();
            ali.add(new FileInputStream("src/main/java/Lesson3/Homework/task2-1.txt"));
            ali.add(new FileInputStream("src/main/java/Lesson3/Homework/task2-2.txt"));
            ali.add(new FileInputStream("src/main/java/Lesson3/Homework/task2-3.txt"));
            ali.add(new FileInputStream("src/main/java/Lesson3/Homework/task2-4.txt"));
            ali.add(new FileInputStream("src/main/java/Lesson3/Homework/task2-5.txt"));
            try (SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali))) {
                try (FileOutputStream out = new FileOutputStream("src/main/java/Lesson3/Homework/task2-result.txt");) {
                    int x;
                    while ((x = in.read()) != -1) {
                        out.write(x);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
