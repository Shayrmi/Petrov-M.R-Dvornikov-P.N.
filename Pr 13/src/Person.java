/* Задача 2 блок 2 практика 13 */
public class Person {
    private final String lastName;
    private final String firstName;   // может быть null
    private final String middleName;  // может быть null

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    /**
     * Возвращает "Фамилия И.О." с учётом отсутствия имени/отчества.
     * Оптимизация: используем StringBuilder с предварительной оценкой размера,
     * избегаем лишних конкатенаций и вызовов substring.
     */
    public String getFullName() {
        StringBuilder sb = new StringBuilder(lastName.length() + 6);
        sb.append(lastName);

        if (firstName != null && !firstName.isEmpty()) {
            sb.append(' ').append(firstName.charAt(0)).append('.');
        }
        if (middleName != null && !middleName.isEmpty()) {
            sb.append(middleName.charAt(0)).append('.');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Person("Иванов", "Иван", "Иванович").getFullName()); // Иванов И.И.
        System.out.println(new Person("Петров", "Пётр", null).getFullName());       // Петров П.
        System.out.println(new Person("Сидоров", null, "Сергеевич").getFullName()); // Сидоров С.
        System.out.println(new Person("Смирнов", null, null).getFullName());         // Смирнов
    }
}