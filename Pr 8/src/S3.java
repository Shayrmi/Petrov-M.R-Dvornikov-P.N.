/* Задание 3 блок 2 практика 8 */
import java.util.Scanner;

public class S3 {
    // Статический сканер — это не глобальная переменная-счётчик,
    // а лишь средство ввода; логика полностью в рекурсии.
    private static final Scanner sc = new Scanner(System.in);

    public static int countOnes() {
        int x = sc.nextInt();

        // Базовый случай: встретили 0
        if (x == 0) {
            int next = sc.nextInt();
            if (next == 0) {
                // Два нуля подряд — конец последовательности
                return 0;
            } else {
                // Один ноль, но последовательность продолжается —
                // ноль не считаем, продолжаем рекурсию
                // (next уже прочитан, его тоже нужно учесть)
                int count = (next == 1) ? 1 : 0;
                return count + countOnes();
            }
        }

        // Шаг рекурсии: x — не ноль
        int current = (x == 1) ? 1 : 0;
        return current + countOnes();
    }

    public static void main(String[] args) {
        System.out.println(countOnes());
    }
}