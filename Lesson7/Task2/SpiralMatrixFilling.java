package Lesson7.Homework.Task2;

public class SpiralMatrixFilling {

    private static int counter;

    private static int[][] fillUp(int[][] arr, int index) {
        for (int i = index; i < arr[index].length - index; i++) {
            arr[index][i] = counter++;
        }
        return arr;
    }

    private static int[][] fillRight(int[][] arr, int countFillLines, int indexColumn) {
        for (int i = countFillLines; i < arr.length - countFillLines + 1; i++) {
            arr[i][indexColumn] = counter++;
        }
        return arr;
    }

    private static int[][] fillBot(int[][] arr, int index) {
        int deltaRight = arr.length - index + 1;
        int deltaLeft = arr.length - index - 1;
        for (int i = arr[index].length - deltaRight; i >= deltaLeft; i--) {
            arr[index][i] = counter++;
        }
        return arr;
    }

    private static int[][] fillLeft(int[][] arr, int countFillLines, int indexColumn) {
        for (int i = arr.length - countFillLines - 1; i >= countFillLines; i--) {
            arr[i][indexColumn] = counter++;
        }
        return arr;
    }

    public static int[][] fill(int[][] arr) {
        counter = 1;
        
        if (arr.length != 0) {
            int count = arr.length * arr[0].length;
            int round = 0;
            while (counter <= count) {
                fillUp(arr, round);

                if (counter > count) {
                    break;
                } else {
                    int indexRightColumn = arr[round].length - round - 1;
                    int countFillLines = round + 1;
                    fillRight(arr, countFillLines, indexRightColumn);
                }

                if (counter > count) {
                    break;
                } else {
                    int indexBotLine = arr.length - round - 1;
                    fillBot(arr, indexBotLine);
                }

                if (counter > count) {
                    break;
                } else {
                    int indexLeftColumn = round;
                    int countFillLines = round + 1;
                    fillLeft(arr, countFillLines, indexLeftColumn);
                }

                round++;
            }
        }

        return arr;
    }

    private static void printArr(int[][] arr, String name) {
        System.out.println(name + ": ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Tests
        int[][] test1 = new int[5][9];
        fill(test1);
        printArr(test1, "test1");

        int[][] test2 = new int[3][3];
        fill(test2);
        printArr(test2, "test2");

        int[][] test3 = new int[10][2];
        fill(test3);
        printArr(test3, "test3");

        int[][] test4 = new int[2][10];
        fill(test4);
        printArr(test4, "test4");

        int[][] test5 = new int[7][3];
        fill(test5);
        printArr(test5, "test5");

        int[][] test6 = new int[5][9];
        fill(test6);
        printArr(test6, "test6");

        int[][] test7 = new int[7][3];
        fill(test7);
        printArr(test7, "test7");

        int[][] test8 = new int[9][5];
        fill(test8);
        printArr(test8, "test8");

        int[][] test9 = new int[5][5];
        fill(test9);
        printArr(test9, "test9");
    }

}
