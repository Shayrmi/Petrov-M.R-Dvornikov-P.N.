/* Задание 6 практика 1 блок 1 */
public class S3 {
    public static void main (String[] args) {
        System.out.println("Первые 10 чисел гармон.ряда:");
        for (int i = 1; i <= 10 ; i++) {
            double term = 5.0 / i;
            System.out.printf ("Член %2d:1/%-2d = %.5f%n",i,i,term );
        }
    }
}

