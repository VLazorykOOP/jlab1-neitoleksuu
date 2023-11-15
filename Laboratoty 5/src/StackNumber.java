import java.util.Stack;
import java.util.ArrayList;

public class StackNumber {
    private Stack<Integer> stack;
    private ArrayList<Integer> directAccessList;

    public StackNumber() {
        stack = new Stack<>();
        directAccessList = new ArrayList<>();
    }

    // Додати номер запису в стек
    public void push(int recordNumber) {
        stack.push(recordNumber);
        directAccessList.add(recordNumber);
    }

    // Вилучити та повернути верхній номер запису зі стеку
    public int pop() {
        if (!stack.isEmpty()) {
            int poppedRecord = stack.pop();
            directAccessList.remove((Integer) poppedRecord); // Видаляємо з ArrayList
            return poppedRecord;
        } else {
            throw new IllegalStateException("Стек порожній");
        }
    }

    // Отримати верхній номер запису без вилучення
    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            throw new IllegalStateException("Стек порожній");
        }
    }

    // Прямий доступ до елементів за номером запису
    public int getRecordByNumber(int recordNumber) {
        if (recordNumber >= 0 && recordNumber < directAccessList.size()) {
            return directAccessList.get(recordNumber);
        } else {
            throw new IndexOutOfBoundsException("Невірний номер запису");
        }
    }

    public static void main(String[] args) {
        StackNumber recordStack = new StackNumber();

        // Додавання номерів записів у стек
        recordStack.push(500);
        recordStack.push(200);
        recordStack.push(300);

        // Отримання та виведення верхнього номеру запису
        System.out.println("Верхній номер запису: " + recordStack.peek());

        // Вилучення та виведення верхнього номеру запису
        System.out.println("Вилучений номер запису: " + recordStack.pop());

        // Прямий доступ до елемента за номером запису
        System.out.println("Елемент за номером 0: " + recordStack.getRecordByNumber(0));
    }
}
