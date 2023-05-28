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
        arrayIntersection(new int[]{1,2},new int[]{2,3});
        System.out.println(missingNumberInArray(new int[]{1,2,3,5}));
        smallestAndLargest(new int[]{1,2,3,4,5,6,7});
        reverseArray(new int[]{1,2,3,4,5});

        HashSet<String> hashset = new HashSet<String>();

        // Adding elements to HashSet object
        hashset.add("Doctor");
        hashset.add("Engineer");
        hashset.add("Lawyer");
        hashset.add("Police");

        // Printing HashSet elements
        System.out.println("HashSet contains: "+ hashset);

        // Creating an Array of HashSet size
        String[] array = new String[hashset.size()];

        // Converting HashSet to Array using toArray() method
        hashset.toArray(array);

        // Printing Array elements
        System.out.println("Array contains: ");
        for (String str : array) {
            System.out.println(str);
        }

        seperateZeroAndNonZeroValues(new int[]{1,3,0,3,0,4,5,0});
        //Converting Array to ArrayList
        String[] cityNames ={"Boston", "Chicago", "San Francisco", "New York"};
        List<String> cityList= new ArrayList<>();
        cityList = Arrays.asList(cityNames);
        System.out.println(cityList);
        System.out.println(cityList.contains("Boston"));

        convertArrayToTreeSet();
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

    public static boolean isEqual(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }

    public static void copyOneArrayToAnother(int[] a){
        int[] b = new int[a.length];
        System.arraycopy(a,0,b,0,a.length);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static int searchForSpecificItem(int[] arr, int item) {
        return Arrays.binarySearch(arr,item);
    }

    public static void arrayIntersection(int[] a, int[] b) {
        int [] c = new int[a.length + b.length];
        int intersectionCounter = 0;
        for (int j : a) {
            for (int i : b) {
                if (j == i) {
                    c[intersectionCounter] = j;
                    ++intersectionCounter;
                }
            }
        }
        System.out.println(Arrays.toString(c));
        for (int k = 0; k < intersectionCounter; k++) {
            System.out.println(c[k]);
        }
    }

    public static int missingNumber(int [] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            sum += i;
        }
        int arrSum = 0;
        for (int j = 0; j < arr.length; j++) {
            arrSum += j;
        }
        return sum - arrSum;
    }

    public static void smallestAndLargest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j < smallest) {
                smallest = j;
            }
            if (j > largest) {
                largest = j;
            }
        }
        System.out.println("Largest value: " + largest);
        System.out.println("Smallest value: " + smallest);
    }

    public static void reverseArray(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - 1 - i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));
    }

    public static void seperateZeroAndNonZeroValues(int[] arr) {
        int counter = 0;
        for (int i: arr) {
            if (i != 0) {
                arr[counter] = i;
                ++counter;
            }
        }
        while (counter < arr.length) {
            arr[counter] = 0;
            ++counter;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void convertArrayToTreeSet() {
        String[] cityNames ={"Boston", "Chicago", "San Francisco", "New York"};
        List<String> list = new ArrayList<>();
         list = Arrays.asList(cityNames);
        Set<String> set = new TreeSet<>(list);
        System.out.println(set);
    }

}
