import java.io.*;

public class Remover {
    public static void main(String[] args) {
        try {
            // Введення назви вхідного та вихідного файлів
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введіть назву вхідного файлу: ");
            String inputFileName = reader.readLine();
            System.out.print("Введіть назву вихідного файлу: ");
            String outputFileName = reader.readLine();

            // Викликаємо метод, який видаляє зайві пропуски
            removeExtraSpaces(inputFileName, outputFileName);

            System.out.println("Зайві пропуски видалено успішно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeExtraSpaces(String inputFileName, String outputFileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        String line;

        while ((line = reader.readLine()) != null) {
            // Видаляємо зайві пропуски в кожному рядку
            line = line.trim().replaceAll("\\s+", " ");
            if (!line.isEmpty()) {
                writer.write(line + "\n");
            }
        }

        reader.close();
        writer.close();
    }
}
