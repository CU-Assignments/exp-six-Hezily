package JavaSem6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " | Marks: " + marks;
    }
}

public class Project6_2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Emma", 88),
                new Student("David", 72),
                new Student("Sophia", 91),
                new Student("Liam", 65),
                new Student("Olivia", 78));

        System.out.println("Students scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted(Comparator.comparingDouble(s -> -s.marks)) // Descending order
                .forEach(System.out::println);
    }
}
