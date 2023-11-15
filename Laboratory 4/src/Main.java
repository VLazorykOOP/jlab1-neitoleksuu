import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Введіть назву вхідного файлу: ");
            String inputFileName = reader.readLine();

            // Читаємо дані з файлу та обробляємо їх
            List<Integer> numbers = processFile(inputFileName);

            // Виводимо суму та усі доданки
            int sum = 0;
            System.out.print("Доданки: ");
            for (Integer number : numbers) {
                System.out.print(number + " ");
                sum += number;
            }
            System.out.println("\nСума: " + sum);

            // Виводимо відсортований список у перший файл
            String sortedFileName = "sorted_" + inputFileName;
            writeSortedNumbersToFile(numbers, sortedFileName);

            // Виводимо рядки без цифр у другий файл
            String noDigitsFileName = "no_digits_" + inputFileName;
            writeLinesWithoutDigitsToFile(inputFileName, noDigitsFileName);

            System.out.println("Результати збережено у файлах: " + sortedFileName + " та " + noDigitsFileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для обробки вхідного файлу та зберігання чисел у списку
    public static List<Integer> processFile(String fileName) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            // Знаходимо цифри у рядку та додаємо їх до списку
            for (char c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    int digit = Character.getNumericValue(c);
                    numbers.add(digit);
                }
            }
        }

        reader.close();
        return numbers;
    }

    // Метод для запису відсортованих чисел у файл
    public static void writeSortedNumbersToFile(List<Integer> numbers, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        // Сортуємо числа та записуємо їх у файл
        Collections.sort(numbers);
        for (Integer number : numbers) {
            writer.write(number + "\n");
        }

        writer.close();
    }

    // Метод для запису рядків без цифр у файл
    public static void writeLinesWithoutDigitsToFile(String inputFileName, String outputFileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        String line;

        while ((line = reader.readLine()) != null) {
            boolean containsDigits = false;
            for (char c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    containsDigits = true;
                    break;
                }
            }

            if (!containsDigits) {
                writer.write(line + "\n");
            }
        }

        reader.close();
        writer.close();
    }
}

