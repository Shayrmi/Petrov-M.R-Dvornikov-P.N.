public class Student implements Comparable<Student> {
    private final int idNumber;
    private final String name;
    private final double gpa;

    public Student(int idNumber, String name, double gpa) {
        this.idNumber = idNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    // Для задания 1: сравнение по номеру студенческого билета
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.idNumber, other.idNumber);
    }

    @Override
    public String toString() {
        return "ID=" + idNumber + ", имя=" + name + ", GPA=" + gpa;
    }
}
