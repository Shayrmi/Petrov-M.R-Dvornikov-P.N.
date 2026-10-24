/* Задание 1 блок 2 практика 8 */
public class S1 {
    public static void printFrom1ToN(int n) {
        // Базовый случай: дошли до 0 — останавливаемся
        if (n == 0) {
            return;
        }
        // Шаг рекурсии: сначала выводим 1..n-1
        printFrom1ToN(n - 1);
        // Затем выводим само n
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 10;
        printFrom1ToN(n); // 1 2 3 4 5 6 7 8 9 10
    }
}