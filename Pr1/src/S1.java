/* Задание 4 практика 1 блок 1 */
public class S1 {
    public static void main(String[] args) {
        int[] numbers = {13, 9, 0, 54, 32, 8};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double g = (double) sum / numbers.length;
        System.out.println("Сумма элементов массва: " + sum);
        System.out.println("Сред.арифм.: " + g);
    }
}
