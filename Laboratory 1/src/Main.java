import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть значення n (дійсне): ");
        double n = scanner.nextDouble();

        System.out.print("Введіть значення m (дійсне): ");
        double m = scanner.nextDouble();

        double result = (n + 1) / (n * n * m + 2) + (m + n) / (m - n) + n * n * n;

        System.out.println("Результат: " + result);
    }
}