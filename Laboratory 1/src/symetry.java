import java.util.Scanner;

public class symetry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть текст: ");
        String text = scanner.nextLine();

        String[] words = text.split("[\\s,.;!?]+");

        System.out.println("Симетричні слова:");

        for (String word : words) {
            if (isSymmetric(word)) {
                System.out.println(word);
            }
        }
    }

    public static boolean isSymmetric(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
