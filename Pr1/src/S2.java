/* Задание 5 практика 1 блок 1 */
public class  S2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Вы не передали ни одного аргумента командной строки.");
            return;
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + i + ": " + args[i]);
        }
    }
}
