
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class masiv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір масиву (n): ");
        int n = scanner.nextInt();

        int[] A = new int[n];

        System.out.println("Введіть елементи масиву A:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        ArrayList<Integer> B = removeDuplicates(A);

        System.out.println("Масив B (без повторень):");
        for (int num : B) {
            System.out.print(num + " ");
        }
    }

    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            if (set.add(num)) {
                result.add(num);
            }
        }

        return result;
    }
}
