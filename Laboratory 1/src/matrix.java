import java.util.Scanner;

public class matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмірність матриці (n): ");
        int n = scanner.nextInt();

        int[][] A = new int[n][n];

        System.out.println("Введіть елементи матриці A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        // Знаходимо максимальний елемент і його позицію
        int maxElement = A[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] > maxElement) {
                    maxElement = A[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // Переставляємо рядки і стовпці, щоб максимальний елемент був в лівому верхньому куті
        int[] tempRow = A[0];
        A[0] = A[maxRow];
        A[maxRow] = tempRow;

        for (int i = 0; i < n; i++) {
            int temp = A[i][0];
            A[i][0] = A[i][maxCol];
            A[i][maxCol] = temp;
        }

        // Виводимо перетворену матрицю
        System.out.println("Матриця з максимальним елементом в лівому верхньому куті:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
