package lab1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;


public class NumberOperations {
    public static void main(String[] args) {
        
        List<Number> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9));

        numbers.add(-24);
        numbers.add(0.213);
        numbers.add(0.0);
        numbers.add(null);

        System.out.println("Original list: " + numbers);

        CollectionPrinter printer = new CollectionPrinter();
        String output = printer.formatCollectionWithRule(numbers, num -> String.valueOf(num.intValue()));
        System.out.println("Whole numbers: " + output);
        output = printer.formatCollectionWithRule(numbers, num -> String.format(Locale.US, "%.2f", num.floatValue()));
        System.out.println("Numbers rounded up to second char after comma: " + output);

        ArraySorter sorter = new ArraySorter();
        Map<Class<?>, List<Object>> map = sorter.sort(numbers);
        System.out.println("Sorted map: " + map);

        List<?> integersObjects = map.get(Integer.class);
        List<Integer> integers = unsafeListCast(integersObjects);
        System.out.println("Integer list: " + integers);
    }

    public static<T> List<T> unsafeListCast(List<?> list) {
        @SuppressWarnings("unchecked")
        List<T> casted = (List<T>)list;
        return casted;
    }
}


class CollectionPrinter {
    public<T> String formatCollectionWithRule(Collection<T> numbers, Function<T, String> rule) {
        String output = "[";
        Boolean first = true;
        for (T num : numbers) {
            String current;
            if (num != null) {
                current = rule.apply(num);
            } else {
                current = "null";
            }

            if (!first) {
                output += ", ";
            }
            output += current;
            first = false;
        }
        output += "]";
        return output;
    }
}


class ArraySorter {
    public Map<Class<?>, List<Object>> sort(List<?> list) {
        Map<Class<?>, List<Object>> map = new HashMap<>();
        for (Object obj : list) {
            if (obj == null) {
                continue;
            }

            Class<?> type = obj.getClass();
            if (map.containsKey(type)) {
                map.get(type).add(obj);
                continue;
            }

            List<Object> newList = new ArrayList<>();
            newList.add(obj);
            map.put(type, newList);
        }

        return map;
    }
}
