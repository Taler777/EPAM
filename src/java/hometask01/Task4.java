package hometask01;

/*
Даны действительные числа a1, a2, ..., a2n.
Найти max (a1 + a2n , a2 + a2n – 1, ... , an + an+1 );
 */

import java.util.Random;

public class Task4 {
    static int n = 10;
    static int size = 2 * n + 1;
    static int[] a = new int[size];
    static Random random = new Random();
    static int max;

    public static void main(String[] args) {

        for (int i = 1; i < size; i++) {
            a[i] = random.nextInt(10);
            System.out.print(a[i] + "  ");
        }
        System.out.println();
        max = a[1] + a[2 * n];
        for (int i = 1; i <= n; i++) {
            System.out.println("a["+i+"] = " + a[i] + "    a["+(2 * n + 1 - i)+"] = " + a[2 * n + 1 - i] + "     Сумма = " + (a[i] + a[2 * n + 1 - i]));
            if (max < a[i] + a[2 * n + 1 - i]) max = a[i] + a[2 * n + 1 - i];
        }
        System.out.println("max = " + max);
    }
}
