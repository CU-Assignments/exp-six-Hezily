package JavaSem6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " | Age: " + age + " | Salary: $" + salary;
    }
}

public class Project6_1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 60000),
                new Employee("Bob", 25, 50000),
                new Employee("Charlie", 35, 70000));

        System.out.println("Sorted by Name:");
        employees.sort(Comparator.comparing(emp -> emp.name));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Age:");
        employees.sort(Comparator.comparingInt(emp -> emp.age));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Salary:");
        employees.sort(Comparator.comparingDouble(emp -> emp.salary));
        employees.forEach(System.out::println);
    }
}
