/* Задача 6 блок 2 практика 13 */
import java.io.*;
import java.util.*;

public class WordChain {

    /**
     * Читает строку из файла (getLine()).
     */
    private static String getLine(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.readLine();
        }
    }

    /**
     * Расставляет слова так, чтобы последняя буква слова совпадала
     * с первой буквой следующего (без учёта регистра). Каждое слово — 1 раз.
     * Возвращает null, если цепочку построить нельзя.
     */
    private static String buildChain(List<String> words) {
        // Ключ — первая буква в нижнем регистре
        Map<Character, List<String>> byFirst = new HashMap<>();
        for (String w : words) {
            char key = Character.toLowerCase(w.charAt(0));
            byFirst.computeIfAbsent(key, k -> new ArrayList<>()).add(w);
        }

        StringBuilder result = new StringBuilder();
        Set<String> used = new HashSet<>();

        // Стартуем с первого слова (можно перебирать старты для надёжности)
        String current = words.get(0);
        used.add(current);
        result.append(current);

        while (used.size() < words.size()) {
            char last = Character.toLowerCase(current.charAt(current.length() - 1));
            List<String> candidates = byFirst.get(last);
            String next = null;
            if (candidates != null) {
                for (String c : candidates) {
                    if (!used.contains(c)) {
                        next = c;
                        break;
                    }
                }
            }
            if (next == null) {
                return null; // тупик
            }
            used.add(next);
            result.append(' ').append(next);
            current = next;
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        // Пример: читаем из файла, переданного аргументом, иначе — тестовая строка
        String line;
        if (args.length > 0) {
            line = getLine(args[0]);
        } else {
            line = "Apple elephant Night table Egg goat Orange";
        }

        String[] parts = line.trim().split("\\s+");
        List<String> words = new ArrayList<>(Arrays.asList(parts));

        String chain = buildChain(words);
        if (chain == null) {
            System.out.println("Цепочку построить невозможно");
        } else {
            System.out.println(chain);
        }
    }
}