package hometask01;

import java.util.ArrayList;
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

    public ArrayList fillArray(int size) {
        ArrayList arrayList = new ArrayList<Double>();
        double element = 0;
        for (int i = 0; i < size; i++) {
            element = 1 / Math.pow(i + 1, 2);
            if (element < Math.exp(1)) {
                arrayList.add(element);
            }
        }
        return arrayList;
    }

    public void searchAndPrintMinIndex(ArrayList<Double> arrayList) {
        System.out.println("The minimum index of the collection is number 0");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("[" + i + "] = " + arrayList.get(i));
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
