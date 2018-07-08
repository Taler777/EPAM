package hometask01;

/*
Составить программу для вычисления значений функции F(x) на отрезке [а, b]
с шагом h. Результат представить в виде таблицы, первый столбец которой – значения
аргумента, второй - соответствующие значения функции:
F(x) = tg(2x) -3
 */
public class Task3 {
    static int a = 1;
    static int b = 16;
    static int h = 3;
    static int x = a;
    static int size = (b - a) / h + 1;
    static double[] f = new double[size];

    public static void main(String[] args) {
        System.out.println("x   f[x]");
        for (int i = 0; i < size; i++, x += h) {
            f[i] = Math.tan(2 * x) - 3;
            System.out.printf("%d\t%f\n", x, f[i]);
        }
    }
}
