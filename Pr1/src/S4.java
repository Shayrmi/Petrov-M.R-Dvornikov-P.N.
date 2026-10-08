/* Задание 7 практика 1 блок 1 */
import java.util.Scanner;
public class S4 {
    public static long Factorial (int n){
        if (n<0){
            System.out.println("Факториал не может быть меньше 0");
            return -1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++ ){
            result *= i;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner F = new Scanner(System.in);
        System.out.print ("Введите число:");
        if (F.hasNextInt()) {
            int num = F.nextInt();
            long G = Factorial(num);
            if (G != -1) {
                System.out.println("Факториал числа " + num + " равен: " + G);
            }
        }else{
            System.out.println("Ошибка:вы ввели не целое число!");
        }
        F.close();
    }
}
