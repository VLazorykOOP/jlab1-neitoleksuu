import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть значення n (ціле): ");
        int n = scanner.nextInt();

        System.out.print("Введіть значення m (ціле): ");
        int m = scanner.nextInt();

        double result = (n + 1) / (n * n * m + 2) + (m + n) / (m - n) + Math.pow(n, 3);

        System.out.println("Результат: " + result);
    }
}

