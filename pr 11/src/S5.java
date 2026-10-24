/* Задача 5 блок 2 практика 11 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class S5 {
    private static final int N = 100_000;      // количество элементов
    private static final int OPS = 10_000;     // количество операций

    public static void main(String[] args) {
        Random rnd = new Random(42);

        System.out.printf("%-22s %15s %15s%n", "Операция", "ArrayList, мс", "LinkedList, мс");
        System.out.println("-".repeat(55));

        // 1. Вставка в конец (add)
        measure("add (в конец)", S5::testAdd, rnd);

        // 2. Вставка в начало (add(0, x))
        measure("add(0, x) в начало", S5::testAddFirst, rnd);

        // 3. Вставка в середину
        measure("add(mid, x)", S5::testAddMiddle, rnd);

        // 4. Удаление из начала
        measure("remove(0)", S5::testRemoveFirst, rnd);

        // 5. Удаление из середины
        measure("remove(mid)", S5::testRemoveMiddle, rnd);

        // 6. Поиск по образцу (contains)
        measure("contains (поиск)", S5::testContains, rnd);
    }

    // ---------- Тесты ----------
    static long testAdd(List<Integer> list, Random rnd) {
        long t = System.nanoTime();
        for (int i = 0; i < N; i++) list.add(rnd.nextInt());
        return System.nanoTime() - t;
    }

    static long testAddFirst(List<Integer> list, Random rnd) {
        // предзаполняем, чтобы вставка шла в непустой список
        for (int i = 0; i < N; i++) list.add(i);
        long t = System.nanoTime();
        for (int i = 0; i < OPS; i++) list.add(0, rnd.nextInt());
        return System.nanoTime() - t;
    }

    static long testAddMiddle(List<Integer> list, Random rnd) {
        for (int i = 0; i < N; i++) list.add(i);
        long t = System.nanoTime();
        for (int i = 0; i < OPS; i++) list.add(list.size() / 2, rnd.nextInt());
        return System.nanoTime() - t;
    }

    static long testRemoveFirst(List<Integer> list, Random rnd) {
        for (int i = 0; i < N; i++) list.add(i);
        long t = System.nanoTime();
        for (int i = 0; i < OPS; i++) list.remove(0);
        return System.nanoTime() - t;
    }

    static long testRemoveMiddle(List<Integer> list, Random rnd) {
        for (int i = 0; i < N; i++) list.add(i);
        long t = System.nanoTime();
        for (int i = 0; i < OPS; i++) list.remove(list.size() / 2);
        return System.nanoTime() - t;
    }

    static long testContains(List<Integer> list, Random rnd) {
        for (int i = 0; i < N; i++) list.add(i);
        int target = N / 2;
        long t = System.nanoTime();
        for (int i = 0; i < OPS; i++) list.contains(target);
        return System.nanoTime() - t;
    }

    // ---------- Замер и вывод ----------
    interface ListTest { long run(List<Integer> list, Random rnd); }

    static void measure(String name, ListTest test, Random rnd) {
        long al = test.run(new ArrayList<>(), new Random(42));
        long ll = test.run(new LinkedList<>(), new Random(42));
        System.out.printf("%-22s %15.3f %15.3f%n", name, al / 1e6, ll / 1e6);
    }
}