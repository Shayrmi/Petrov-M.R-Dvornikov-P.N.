/* Задача 4 блок 2 практика 11 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class S4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        System.out.print("Введите месяц (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Введите число: ");
        int day = scanner.nextInt();
        System.out.print("Введите часы (0-23): ");
        int hours = scanner.nextInt();
        System.out.print("Введите минуты (0-59): ");
        int minutes = scanner.nextInt();

        // --- Вариант 1: Calendar / GregorianCalendar ---
        Calendar cal = new GregorianCalendar();
        cal.clear(); // сбрасываем все поля, чтобы не тянуть текущие значения
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1); // в Calendar месяцы 0-11
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date dateFromCalendar = cal.getTime();

        // --- Вариант 2: Date через getTimeInMillis ---
        Date dateDirect = new Date(cal.getTimeInMillis());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("Calendar -> Date: " + sdf.format(dateFromCalendar));
        System.out.println("Date напрямую:    " + sdf.format(dateDirect));

        // Альтернатива — через System.currentTimeMillis + смещение не требуется,
        // т.к. пользователь задаёт полную дату.
        scanner.close();
    }
}