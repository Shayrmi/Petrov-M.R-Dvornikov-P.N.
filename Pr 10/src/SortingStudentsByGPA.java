import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Задание 2: сортировка студентов по среднему баллу (по убыванию).
 * Также демонстрируются сортировка слиянием и сортировка по другому полю.
 */
public class SortingStudentsByGPA implements Comparator<Student> {
    private Student[] iDNumber;

    public SortingStudentsByGPA() {
        setArray();
    }

    // 1) Заполнение массива студентов.
    public void setArray() {
        iDNumber = new Student[] {
            new Student("Иван", "Иванов", "Информатика", 2, "ИКБО-12-24", 86.5),
            new Student("Мария", "Петрова", "Программная инженерия", 1, "ИКБО-11-25", 94.0),
            new Student("Алексей", "Сидоров", "Информатика", 3, "ИКБО-31-23", 78.5),
            new Student("Анна", "Смирнова", "Прикладная математика", 2, "ПМ-22-24", 91.0),
            new Student("Дмитрий", "Кузнецов", "Программная инженерия", 1, "ИКБО-13-25", 86.5)
        };
    }

    // Comparator: больший средний балл должен идти раньше.
    @Override
    public int compare(Student a, Student b) {
        return Double.compare(b.getAverageScore(), a.getAverageScore());
    }

    // 2a) Быстрая сортировка (Quick Sort).
    public void quicksort() {
        quicksort(iDNumber, 0, iDNumber.length - 1);
    }

    private void quicksort(Student[] array, int low, int high) {
        if (low >= high) return;
        int i = low;
        int j = high;
        Student pivot = array[low + (high - low) / 2];

        while (i <= j) {
            while (compare(array[i], pivot) < 0) i++;
            while (compare(array[j], pivot) > 0) j--;
            if (i <= j) {
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) quicksort(array, low, j);
        if (i < high) quicksort(array, i, high);
    }

    // 2b) Сортировка слиянием (Merge Sort).
    public void mergeSort() {
        if (iDNumber.length < 2) return;
        Student[] buffer = new Student[iDNumber.length];
        mergeSort(iDNumber, buffer, 0, iDNumber.length - 1);
    }

    private void mergeSort(Student[] array, Student[] buffer, int left, int right) {
        if (left >= right) return;
        int middle = left + (right - left) / 2;
        mergeSort(array, buffer, left, middle);
        mergeSort(array, buffer, middle + 1, right);

        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (compare(array[i], array[j]) <= 0) buffer[k++] = array[i++];
            else buffer[k++] = array[j++];
        }
        while (i <= middle) buffer[k++] = array[i++];
        while (j <= right) buffer[k++] = array[j++];
        for (int p = left; p <= right; p++) array[p] = buffer[p];
    }

    // 4) Сортировка по другому полю — фамилии по алфавиту.
    public void sortBySurname() {
        Arrays.sort(iDNumber, Comparator.comparing(Student::getSurname,
                String.CASE_INSENSITIVE_ORDER).thenComparing(Student::getName,
                String.CASE_INSENSITIVE_ORDER));
    }

    // Дополнительный пример: сортировка по курсу, затем по фамилии.
    public void sortByCourse() {
        Arrays.sort(iDNumber, Comparator.comparingInt(Student::getCourse)
                .thenComparing(Student::getSurname, String.CASE_INSENSITIVE_ORDER));
    }

    // 3) Вывод массива студентов.
    public void outArray() {
        for (Student student : iDNumber) System.out.println(student);
    }

    public Student[] getStudents() {
        return iDNumber.clone();
    }

    public static void main(String[] args) {
        SortingStudentsByGPA tester = new SortingStudentsByGPA();

        System.out.println("Исходный список:");
        tester.outArray();

        System.out.println("\\nБыстрая сортировка по среднему баллу (по убыванию):");
        tester.quicksort();
        tester.outArray();

        tester.setArray();
        System.out.println("\\nСортировка слиянием по среднему баллу (по убыванию):");
        tester.mergeSort();
        tester.outArray();

        tester.setArray();
        System.out.println("\\nСортировка по фамилии:");
        tester.sortBySurname();
        tester.outArray();

        tester.setArray();
        System.out.println("\\nСортировка по курсу, затем по фамилии:");
        tester.sortByCourse();
        tester.outArray();
    }
}
