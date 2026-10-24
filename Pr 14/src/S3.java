/* Задача 3 Блок 2 Практика 14 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S3 {

    public static void main(String[] args) {
        String text = "Товар A стоит 25.98 USD, товар B — 100 RUB, "
                + "товар C — 44 ERR, товар D — 0.004 EU, "
                + "товар E — 15.50 EU, товар F — 7 RUB.";

        // Цена: число (целое или дробное) + пробел + валюта (USD|RUB|EU)
        // \b — границы слова, чтобы не захватывать лишнее
        String regex = "\\b\\d+(?:\\.\\d+)?\\s?(?:USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные корректные цены:");
        while (matcher.find()) {
            System.out.println("  " + matcher.group());
        }
    }
}