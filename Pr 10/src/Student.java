import java.util.Objects;

/**
 * Модель студента для практической работы № 10.
 */
public class Student {
    private String name;
    private String surname;
    private String specialty;
    private int course;
    private String group;
    private double averageScore;

    public Student(String name, String surname, String specialty,
                   int course, String group, double averageScore) {
        setName(name);
        setSurname(surname);
        setSpecialty(specialty);
        setCourse(course);
        setGroup(group);
        setAverageScore(averageScore);
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = requireText(name, "Имя");
    }

    public String getSurname() { return surname; }
    public void setSurname(String surname) {
        this.surname = requireText(surname, "Фамилия");
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) {
        this.specialty = requireText(specialty, "Специальность");
    }

    public int getCourse() { return course; }
    public void setCourse(int course) {
        if (course < 1) throw new IllegalArgumentException("Курс должен быть не меньше 1.");
        this.course = course;
    }

    public String getGroup() { return group; }
    public void setGroup(String group) {
        this.group = requireText(group, "Группа");
    }

    public double getAverageScore() { return averageScore; }
    public void setAverageScore(double averageScore) {
        if (Double.isNaN(averageScore) || averageScore < 0 || averageScore > 100) {
            throw new IllegalArgumentException("Средний балл должен быть от 0 до 100.");
        }
        this.averageScore = averageScore;
    }

    private static String requireText(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " не может быть пустым.");
        }
        return value.trim();
    }

    @Override
    public String toString() {
        return String.format("%s %s | специальность: %s | курс: %d | группа: %s | средний балл: %.2f",
                surname, name, specialty, course, group, averageScore);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return course == other.course
                && Double.compare(averageScore, other.averageScore) == 0
                && Objects.equals(name, other.name)
                && Objects.equals(surname, other.surname)
                && Objects.equals(specialty, other.specialty)
                && Objects.equals(group, other.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, specialty, course, group, averageScore);
    }
}
