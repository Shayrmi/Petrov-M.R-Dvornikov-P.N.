import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    // Для задания 2: сортировка по GPA по убыванию
    @Override
    public int compare(Student first, Student second) {
        return Double.compare(second.getGpa(), first.getGpa());
    }

    public static void quickSort(Student[] students, int low, int high,
                                 Comparator<Student> comparator) {
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        Student pivot = students[low + (high - low) / 2];

        while (i <= j) {
            while (comparator.compare(students[i], pivot) < 0) {
                i++;
            }
            while (comparator.compare(students[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(students, low, j, comparator);
        }
        if (i < high) {
            quickSort(students, i, high, comparator);
        }
    }
}
