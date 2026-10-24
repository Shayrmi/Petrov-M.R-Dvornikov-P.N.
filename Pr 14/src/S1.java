/* Задача 1 Блок 2 Практика 14 */
import java.util.Scanner;
import java.util.regex.Pattern;

public class S1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Разбиение строки регулярным выражением ===");
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        System.out.print("Введите регулярное выражение-разделитель (например, \\s+|[,;]): ");
        String regex = scanner.nextLine();

        try {
            // Pattern.split(CharSequence) — разбивает строку, используя шаблон как разделитель
            Pattern pattern = Pattern.compile(regex);
            String[] parts = pattern.split(input);

            System.out.println("\nРезультат разбиения (" + parts.length + " элементов):");
            int i = 1;
            for (String part : parts) {
                System.out.println(i++ + ": \"" + part + "\"");
            }

            // Дополнительно: split с limit
            System.out.print("\nВведите limit (0 — без ограничения): ");
            int limit = Integer.parseInt(scanner.nextLine().trim());
            String[] limited = pattern.split(input, limit);
            System.out.println("Разбиение с limit=" + limit + ":");
            for (String part : limited) {
                System.out.println("  \"" + part + "\"");
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}