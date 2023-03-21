import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(10));
        }
        System.out.println(integerList);

        System.out.println("Задание 1");
        findMinMax(integerList.stream(),
                Comparator.naturalOrder(),
                (x, y) -> System.out.printf("min: %s, max: %s%n", x, y));


        System.out.println("Задание 2");
        checkInt(integerList);
    }

    public static void checkInt(List<Integer> integerList) {

        System.out.println(integerList.stream()
                .filter(i -> i % 2 == 0)
                .peek(System.out::println)
                .count());
    }

}
