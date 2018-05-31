package hometask01;

/*
Make an array with diagonal's values like 1
 */
public class Task5 {
    private static final int SIZE = 9;
    private static int[][] array = new int[SIZE][SIZE];

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j || i == SIZE - 1 - j) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
