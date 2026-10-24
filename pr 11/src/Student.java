/* Задача 3 блок 2 практика 11 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    private String fullName;
    private int groupNumber;
    private Date birthDate;

    public Student(String fullName, int groupNumber, Date birthDate) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.birthDate = birthDate;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public int getGroupNumber() { return groupNumber; }
    public void setGroupNumber(int groupNumber) { this.groupNumber = groupNumber; }
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    /**
     * Возвращает строковое представление даты рождения в заданном формате.
     * @param format шаблон SimpleDateFormat, например "dd.MM.yyyy"
     */
    public String getBirthDateFormatted(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(birthDate);
    }

    /** Короткий формат: 15.03.2003 */
    public String getBirthDateShort() {
        return getBirthDateFormatted("dd.MM.yy");
    }

    /** Средний формат: 15 мар. 2003 */
    public String getBirthDateMedium() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("ru"));
        return sdf.format(birthDate);
    }

    /** Полный формат: 15 марта 2003 г. */
    public String getBirthDateFull() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy 'г.'", new Locale("ru"));
        return sdf.format(birthDate);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", groupNumber=" + groupNumber +
                ", birthDate=" + getBirthDateFormatted("dd.MM.yyyy") +
                '}';
    }

    // Демонстрация
    public static void main(String[] args) {
        // 15 марта 2003 г.
        Date birth = new Date(104, 2, 15); // год от 1900, месяц 0-11
        Student s = new Student("Петров Пётр Петрович", 101, birth);

        System.out.println(s);
        System.out.println("Короткий формат: " + s.getBirthDateShort());
        System.out.println("Средний формат:  " + s.getBirthDateMedium());
        System.out.println("Полный формат:   " + s.getBirthDateFull());
        System.out.println("Свой формат:     " + s.getBirthDateFormatted("yyyy/MM/dd"));
    }
}