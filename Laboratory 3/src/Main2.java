// Абстрактний базовий клас Currency
abstract class Currency {
    // Поле, що зберігає суму валюти
    protected double amount;

    // Конструктор класу, приймає суму валюти
    public Currency(double amount) {
        this.amount = amount;
    }

    // Абстрактний метод для конвертації в гривні
    public abstract double convertToUAH();

    // Абстрактний метод для виводу інформації про суму валюти
    public abstract void display();
}

// Похідний клас Dollar
class Dollar extends Currency {
    // Конструктор класу, викликає конструктор базового класу
    public Dollar(double amount) {
        super(amount);
    }

    // Реалізація методу конвертації доларів в гривні
    @Override
    public double convertToUAH() {
        return amount * 38.0; // курс долара
    }

    // Реалізація методу виводу інформації про суму доларів
    @Override
    public void display() {
        System.out.println(amount + " доларів");
    }

    // Перевизначення методу toString для коректного виводу
    @Override
    public String toString() {
        return amount + " доларів";
    }

    // Перевизначення методу equals для порівняння двох об'єктів
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dollar dollar = (Dollar) obj;
        return Double.compare(dollar.amount, amount) == 0;
    }
}

// Похідний клас Euro
class Euro extends Currency {
    // Конструктор класу, викликає конструктор базового класу
    public Euro(double amount) {
        super(amount);
    }

    // Реалізація методу конвертації євро в гривні
    @Override
    public double convertToUAH() {
        return amount * 37.0; // курс євро
    }

    // Реалізація методу виводу інформації про суму євро
    @Override
    public void display() {
        System.out.println(amount + " євро");
    }

    // Перевизначення методу toString для коректного виводу
    @Override
    public String toString() {
        return amount + " євро";
    }

    // Перевизначення методу equals для порівняння двох об'єктів
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Euro euro = (Euro) obj;
        return Double.compare(euro.amount, amount) == 0;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Currency[] currencies = new Currency[2];
        currencies[0] = new Dollar(100); // Створення об'єкту класу Dollar з сумою 100 доларів
        currencies[1] = new Euro(50);   // Створення об'єкту класу Euro з сумою 50 євро

        for (Currency currency : currencies) {
            currency.display();                 // Виведення інформації про суму валюти
            System.out.println("У гривні: " + currency.convertToUAH()); // Конвертація в гривні та виведення
            System.out.println("ToString: " + currency.toString());       // Виведення з використанням toString()
            System.out.println("Equals: " + currency.equals(currencies[0])); // Порівняння з іншим об'єктом
            System.out.println("--------------------");
        }
    }
}
