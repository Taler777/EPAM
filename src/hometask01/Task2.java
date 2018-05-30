package hometask01;

import java.util.Scanner;

public class Task2 {
    public int askCount() {
        int size;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a count of numbers:");
            if (!scanner.hasNextInt()) {
                System.out.println("Wrong number");
                scanner.next();
                continue;
            } else {
                size = Integer.parseInt(scanner.next());
                break;
            }
        }
        scanner.close();
        return size;
    }

    public double[] fillArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1 / Math.pow(size + 1, 2);
        }
        return array;
    }

    public void searchAndPrintMinIndex(double[] array) {
        double min = 0;
        int indexMin = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                indexMin = i;
            }
        }
        System.out.println("Minimum element is " + indexMin);
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }
        return;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.searchAndPrintMinIndex(
                task2.fillArray(
                        task2.askCount()));
    }
}
