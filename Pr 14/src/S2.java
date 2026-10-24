/* Задача 2 Блок 2 Практика 14 */
import java.util.regex.Pattern;

public class S2 {

    public static void main(String[] args) {
        // Шаблон: строго заданная последовательность букв + 18340
        String regex = "^abcdefghijklmnopqrstuv18340$";
        Pattern pattern = Pattern.compile(regex);

        String[] tests = {
                "abcdefghijklmnopqrstuv18340",        // правильно
                "abcdefghijklmnoasdfasdpqrstuv18340"  // неправильно
        };

        for (String s : tests) {
            boolean ok = pattern.matcher(s).matches();
            System.out.println("\"" + s + "\" -> " + (ok ? "СООТВЕТСТВУЕТ" : "НЕ СООТВЕТСТВУЕТ"));
        }
    }
}