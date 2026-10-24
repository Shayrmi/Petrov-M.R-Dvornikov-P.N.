/* Задача 5 блок 2 практика 13 */
public class PhoneNumber {
    private final String formatted;

    public PhoneNumber(String raw) {
        String digits;
        String countryCode;

        if (raw.startsWith("+")) {
            // формат +<код страны><10 цифр>
            String body = raw.substring(1);
            // код страны — 1..3 цифры; определяем по длине: всего 10 цифр номера
            int codeLen = body.length() - 10;
            countryCode = body.substring(0, codeLen);
            digits = body.substring(codeLen);
        } else if (raw.startsWith("8") && raw.length() == 11) {
            // российский формат 8XXXXXXXXXX
            countryCode = "7";
            digits = raw.substring(1);
        } else {
            throw new IllegalArgumentException("Неизвестный формат: " + raw);
        }

        if (digits.length() != 10) {
            throw new IllegalArgumentException("Номер должен содержать 10 цифр: " + raw);
        }

        StringBuilder sb = new StringBuilder("+");
        sb.append(countryCode).append(' ')
                .append(digits, 0, 3).append(' ')
                .append(digits, 3, 6).append(' ')
                .append(digits, 6, 10);
        this.formatted = sb.toString();
    }

    @Override
    public String toString() {
        return formatted;
    }

    public static void main(String[] args) {
        System.out.println(new PhoneNumber("+79175655655")); // +7 917 565 5655
        System.out.println(new PhoneNumber("+104289652211")); // +10 428 965 2211
        System.out.println(new PhoneNumber("89175655655"));   // +7 917 565 5655
    }
}