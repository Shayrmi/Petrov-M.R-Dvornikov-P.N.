/* Задача 1 блок 2 практика 11 */
import java.util.Date;
import java.text.SimpleDateFormat;

public class S1 {
    public static void main(String[] args) {
        // ФИО разработчика
        String developer = "Иванов Иван Иванович";

        // Дата и время получения задания — задаём вручную (например, начало пары)
        long receivedMillis = System.currentTimeMillis() - 2 * 60 * 60 * 1000L; // 2 часа назад
        Date received = new Date(receivedMillis);

        // Дата и время сдачи задания — текущий момент (класс Date)
        Date submitted = new Date(); // эквивалентно new Date(System.currentTimeMillis())

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("Разработчик: " + developer);
        System.out.println("Дата и время получения задания: " + sdf.format(received));
        System.out.println("Дата и время сдачи задания:      " + sdf.format(submitted));
    }
}
