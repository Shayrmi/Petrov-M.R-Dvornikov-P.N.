/* Задача 1 блок 2 практика 13 */
public class S1 {
    public static void main(String[] args) {
        String s = "I like Java!!!";

        // 2. Последний символ строки
        char lastChar = s.charAt(s.length() - 1);
        System.out.println("Последний символ: " + lastChar);

        // 3. Заканчивается ли строкой "!!!"
        System.out.println("Заканчивается на \"!!!\": " + s.endsWith("!!!"));

        // 4. Начинается ли с "I like"
        System.out.println("Начинается с \"I like\": " + s.startsWith("I like"));

        // 5. Содержит ли "Java"
        System.out.println("Содержит \"Java\": " + s.contains("Java"));

        // 6. Позиция подстроки "Java"
        int pos = s.indexOf("Java");
        System.out.println("Позиция \"Java\": " + pos);

        // 7. Замена всех 'a' на 'o'
        String replaced = s.replace('a', 'o');
        System.out.println("Замена a->o: " + replaced);

        // 8. Верхний регистр
        System.out.println("Верхний регистр: " + s.toUpperCase());

        // 9. Нижний регистр
        System.out.println("Нижний регистр: " + s.toLowerCase());

        // 10. Вырезать "Java"
        String cut = s.substring(0, pos) + s.substring(pos + "Java".length());
        System.out.println("Без \"Java\": " + cut);
    }
}