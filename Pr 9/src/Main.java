import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
            new Student(104, "Анна", 4.3),
            new Student(101, "Иван", 3.8),
            new Student(103, "Мария", 4.9),
            new Student(102, "Павел", 4.1)
        };

        // Задание 1. Сортировка вставками по idNumber (по возрастанию)
        Student[] byId = Arrays.copyOf(students, students.length);
        insertionSort(byId);

        System.out.println("Задание 1 — сортировка по ID:");
        for (Student student : byId) {
            System.out.println(student);
        }

        // Задание 2. Быстрая сортировка по GPA (по убыванию)
        Student[] byGpa = Arrays.copyOf(students, students.length);
        SortingStudentsByGPA comparator = new SortingStudentsByGPA();
        SortingStudentsByGPA.quickSort(byGpa, 0, byGpa.length - 1, comparator);

        System.out.println("\\nЗадание 2 — сортировка по GPA:");
        for (Student student : byGpa) {
            System.out.println(student);
        }
    }

    public static void insertionSort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student current = students[i];
            int j = i - 1;

            while (j >= 0 && students[j].compareTo(current) > 0) {
                students[j + 1] = students[j];
                j--;
            }

            students[j + 1] = current;
        }
    }
}
