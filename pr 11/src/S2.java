/* Задача 2 блок 2 практика 11 */
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        sdf.setLenient(false);

        System.out.print("Введите дату и время (dd.MM.yyyy HH:mm): ");
        String input = scanner.nextLine();

        try {
            Date userDate = sdf.parse(input);
            Date now = new Date();

            System.out.println("Текущая дата/время:   " + sdf.format(now));
            System.out.println("Введённая дата/время: " + sdf.format(userDate));

            int cmp = now.compareTo(userDate);
            if (cmp > 0) {
                System.out.println("Введённая дата находится в ПРОШЛОМ относительно текущего времени.");
            } else if (cmp < 0) {
                System.out.println("Введённая дата находится в БУДУЩЕМ относительно текущего времени.");
            } else {
                System.out.println("Даты совпадают.");
            }

            // Дополнительно — методы after/before
            System.out.println("now.after(userDate)  = " + now.after(userDate));
            System.out.println("now.before(userDate) = " + now.before(userDate));
        } catch (ParseException e) {
            System.out.println("Ошибка: неверный формат даты. " + e.getMessage());
        }
        scanner.close();
    }
}