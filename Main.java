import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        String [] strings = new String[]{"dennis", "masinde","chengwa"};
        List<String> listStrings = arrayToArrayList(strings);
        listStrings.forEach(System.out::println);
        createArrayFromUserInput();
        List<Integer> arr1 = List.of(1,2,3);
        List<Integer> arr2 = List.of(3,4,5);
        List<Integer> arr3 = List.of(5,6,7);
        List<List<Integer>> integerArray = List.of(arr1,arr2,arr3);
        System.out.println("-------------------------");
        presentInTwoOrMoreArrays(integerArray).forEach(System.out::println);
        System.out.println("-------------------------");
        int duplicate = firstDuplicateInArray(new int[]{2,3,4,5,5,6});
        System.out.println(duplicate);
        System.out.println(Arrays.toString(deleteElementFromArray(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(missingNumberInArray(new int[]{1,2,3,4,5,7}));
    }

    public static int firstDuplicateInArray(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (Integer i: arr) {
            if (set.contains(i)){
                return i;
            } else {
                set.add(i);
            }
        }
        return 0;
    }

    public static int[] deleteElementFromArray(int [] arr, int index) {
        return IntStream
                .range(0, arr.length)
                .filter(item -> item != index)
                .map(item -> arr[item])
                .toArray();
    }

    public static Set<Integer> presentInTwoOrMoreArrays(List<List<Integer>> arrays) {
        Set<Integer> duplicateValues = new HashSet<>();
        Set<Integer> uniqueValues = new HashSet<>();
        for (List<Integer> array : arrays) {
            uniqueValues.addAll(array);
        }
        for (int i = 0; i < 1; i++) {
            for (Integer j : uniqueValues) {
                List<Integer> a1 = arrays.get(i);
                List<Integer> a2 = arrays.get(i+1);
                List<Integer> a3 = arrays.get(i+2);

                if (a1.contains(j) && a2.contains(j) ||
                        a2.contains(j) && a3.contains(j) ||
                            a1.contains(j) && a3.contains(j)) {
                    duplicateValues.add(j);
                }
            }
        }
         return duplicateValues;
    }
    public static int missingNumberInArray(int [] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < arr.length + 1; i++) {
            set.add(i);
        }
        for (Integer i: arr) {
            set.remove(i);
        }
        return set.stream().findFirst().isPresent() ? set.stream().findFirst().get() : 0;
    }

    public static void createArrayFromUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter a value: ");
            arr[i] = input.nextInt();
        }
        input.close();
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static List<String> arrayToArrayList(String [] names) {
        return Arrays.asList(names);
    }
}
