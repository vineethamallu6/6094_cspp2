import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for sorted set.
 */
class SortedSet extends Set{
    public int[] set;

    /**
     * indicates the number of elememnts of this set.
     */
    public int size;

    /**
     * Default constructor to create an array with the szie 10.
     */
    public SortedSet() {
        set = new int[10];
        size = 0;
    }
    /**
     * sort function.
     *
     * @param      array  The array
     */
    public void sort(final int[] array) {
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    /**
     * add function.
     *
     * @param      item  The item
     */
    public int size() {
        return size;
    }
    public void add(final int item) {
        if (!contains(item)) {
            set[size++] = item;
        }
        sort(set);
    }
    public String intersection(SortedSet otherSet) {
    SortedSet intersection = new SortedSet();
    int j = 0;
    for (int i = 0; i < size; i++) {
        for (j = 0; j < otherSet.size(); j++) {
        if(set[i] == otherSet.get(j)) {
            intersection.add(set[i]);
            //System.out.println(j);
            //System.out.println(i);
        }
        }
    }
    return intersection.toString();
 }
 public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return set[index];
    }
}
    public SortedSet retainAll(final int[] arr) {
        SortedSet result = new SortedSet();
        int j = 0;
    for (int i = 0; i < size; i++) {
        for (j = 0; j < arr.length; j++) {
        if (set[i] == arr[j]) {
            result.add(arr[j]);
            j++;
        }
    }
    }
    return result;
    }
    public boolean contains(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * subset.
     *
     * @param      start  The start
     * @param      end    The end
     *
     * @return     from start to end returns elements.
     */
    public int[] subSet(final int start, final int end) {
        if (start > end) {

        }
        int[] result = new int[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] >= start) {
                for (int j = i; j < size; j++) {
                    if (set[j] < end) {
                        result[k++] = set[i];
                    }
                    break;
                }
            }
        }
        return Arrays.copyOf(result, k);
    }
    /**
     * headset function.
     *
     * @param      end   The end
     *
     * @return     returms elements.
     */
    public int[] headSet(final int end) {
        int[] result = new int[size];
        int temp = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] < end) {
                result[i] = set[i];
                temp++;
            }
        }
        return Arrays.copyOf(result, temp);
    }
    /**
     * last function.
     *
     * @return     returns list of elements.
     */
    public int last() {
        if (size == 0) {
            System.out.println("Set Empty Exception");
            return -1;
        }
        return set[size - 1];
    }
    /**
     * Adds all.
     *
     * @param      element  The element
     */
    public void addAll(final int[] element) {
        for (int i : element) {
            this.add(i);
        }
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        SortedSet s = new SortedSet();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.addAll(intArray);
                }
                break;
            case "intersection":
                s = new SortedSet();
                SortedSet t = new SortedSet();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            //case "cartesianProduct":
                //s = new SortedSet();
                //t = new SortedSet();
                //intArray = intArray(tokens[1]);
                //s.add(intArray);
                //intArray = intArray(tokens[2]);
                //t.add(intArray);
                //System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                //break;
            case "subSet":

                if (tokens.length != 2) {
                    break;
                }
                String[] arrstring3 = tokens[1].split(",");
                int[] object = s.subSet(Integer.parseInt(arrstring3[0]),
                                        Integer.parseInt(arrstring3[1]));
                if (object != null) {
                    System.out.println(Arrays.toString(object).replace("[",
                        "{").replace("]", "}"));

            }

                break;
            case "headSet":
                if (tokens.length != 2) {
                    break;
                }
                int[] obj = s.headSet(Integer.parseInt(tokens[1]));
                if (obj != null) {
                    System.out.println(Arrays.toString(obj).replace("[",
                        "{").replace("]", "}"));
                }
                break;
            case "last":
                if (tokens.length != 1) {
                    break;
                }
                int temp = s.last();
                System.out.println(temp);
                break;
            case "addAll":
                int[] intArr = intArray(tokens[1]);
                if (intArr.length == 1) {
                    s.add(intArr[0]);
                } else {
                    s.addAll(intArr);
                }
                break;
            default:
                break;
            }
        }
    }
}
