// Інтерфейс для валюти
interface Currency1 {
    double convertToUAH();
    void display();
}

// Похідний клас Dollar, який реалізує інтерфейс Currency
class Dollar1 implements Currency1 {
    protected double amount;

    public Dollar1(double amount) {
        this.amount = amount;
    }

    @Override
    public double convertToUAH() {
        return amount * 38.0; //
    }

    @Override
    public void display() {
        System.out.println(amount + " доларів");
    }

    @Override
    public String toString() {
        return amount + " доларів";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dollar dollar = (Dollar) obj;
        return Double.compare(dollar.amount, amount) == 0;
    }
}

// Похідний клас Euro, який реалізує інтерфейс Currency
class Euro1 implements Currency1 {
    protected double amount;

    public Euro1(double amount) {
        this.amount = amount;
    }

    @Override
    public double convertToUAH() {
        return amount * 37.0;
    }

    @Override
    public void display() {
        System.out.println(amount + " євро");
    }

    @Override
    public String toString() {
        return amount + " євро";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Euro euro = (Euro) obj;
        return Double.compare(euro.amount, amount) == 0;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Currency[] currencies = new Currency[2];
        currencies[0] = new Dollar(100);
        currencies[1] = new Euro(50);

        for (Currency currency : currencies) {
            currency.display();
            System.out.println("У гривні: " + currency.convertToUAH());
            System.out.println("ToString: " + currency.toString());
            System.out.println("Equals: " + currency.equals(currencies[0]));
            System.out.println("--------------------");
        }
    }
}
