/* Задание 7 блок 2 практика 8 */
public class S2 {
    public static void factorize(int n, int divisor) {
        // Базовый случай: число полностью разложено
        if (n == 1) {
            return;
        }
        // Ищем делитель, начиная с текущего divisor
        while (divisor <= n) {
            if (n % divisor == 0) {
                System.out.print(divisor + " ");
                // Шаг рекурсии: раскладываем оставшуюся часть,
                // начиная с того же делителя (учитываем кратность)
                factorize(n / divisor, divisor);
                return;
            }
            divisor++;
        }
    }

    public static void main(String[] args) {
        int n = 360;
        factorize(n, 2); // 2 2 2 3 3 5
        System.out.println();
    }
}