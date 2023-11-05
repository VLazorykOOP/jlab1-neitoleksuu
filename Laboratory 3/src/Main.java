// Суперклас Employee
class Employee {
    //обмеження доступу до змінних чи методів класу ззовні, але дозволяє цим елементам бути доступними в підкласах та в тому ж пакеті.
    protected String name;
    protected int age;
    protected double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void Show() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}

// Підклас Kadry
class Kadry extends Employee {
    private String department;

    public Kadry(String name, int age, double salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Department: " + department);
    }
}

// Підклас Engineer
class Engineer extends Employee {
    private String specialization;

    public Engineer(String name, int age, double salary, String specialization) {
        super(name, age, salary);
        this.specialization = specialization;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Specialization: " + specialization);
    }
}

// Підклас Administration
class Administration extends Employee {
    private String position;

    public Administration(String name, int age, double salary, String position) {
        super(name, age, salary);
        this.position = position;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Position: " + position);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Kadry("John Doe", 30, 3000.0, "HR");
        employees[1] = new Engineer("Jane Smith", 35, 4000.0, "Software Engineer");
        employees[2] = new Administration("Bob Johnson", 40, 3500.0, "Manager");

        for (Employee employee : employees) {
            employee.Show();
            System.out.println("--------------------");
        }
    }
}
