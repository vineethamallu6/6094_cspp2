import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author : Vineetha.
 */
class SortedSet extends SetSolution {
    /**
     * integer array named set.
     */
    private int[] set;
    /**
     * integer variable named size.
     */
    private int size;
    /**
     * variable with value 10.
     */
    private final int variable = 10;
    /**
     * Constructor for the object "Sortedset".
     */
    SortedSet() {
        set = new int[variable];
        size = 0;
    }
    /**
     * constructor for object "SortedSet".
     *
     * @param  items int array for the constructor.
     */
    SortedSet(final int[] items) {
        set = new int[variable];
        size = 0;
        addAll(items);
    }
    /**
     * method to return size of set.
     *
     * @return returns the size of set.
     */
    public int size() {
        return size;
    }
    /**
     * returns true if the element is in set.
     *
     * @param      searchvariable  variable.
     *
     * @return     returns true or false.
     */
    public boolean contains(final int searchvariable) {
        for (int i = 0; i < size; i++) {
            if (set[i] == searchvariable) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String result = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            result = result + set[i] + ", ";
        }
        result = result + set[i] + "}";
        return result;
    }
    /**
     * method to add the given set of elements into set.
     * @param  newArray integer array to be inserted into set.
     */
    public void addAll(final int[] newArray) {
        for (int element : newArray) {
            add(element);
        }
        set = Arrays.copyOf(set, size);
        Arrays.sort(set);
    }
    /**
     * method to add the given element into set.
     * @param  element variable to be inserted into set.
     */
    public void add(final int element) {
        if (!contains(element)) {
            if (size == set.length) {
                resize();
            }
            set[size++] = element;
        }
    }
    /**
     * method to resize the size of set.
     */
    public void resize() {
        int resizefactor = 2;
        int[] temporarySet = new int[resizefactor * size];
        for (int i = 0; i < size; i++) {
            temporarySet[i] = set[i];
        }
        set = temporarySet;
    }
    /**
     * method to get the element at index.
     *
     * @param index The index variable.
     *
     * @return  returns the value at particular index.
     */
    public int get(final int index) {
        return set[index];
    }
    /**
     * method to return subset of set.
     *
     * @param  fromElement Start element of subset.
     * @param  toElement end element of subset.
     *
     * @return returns the subset of the set.
     */
    public int[] subSet(final int fromElement, final  int toElement) {
        int[] resultSet = new int[variable];
        int subsetSize = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] >= fromElement && set[i] < toElement) {
                resultSet[subsetSize++] = set[i];
            }
        }
        resultSet = Arrays.copyOf(resultSet, subsetSize);
        return resultSet;
    }
    /**
     * method to return the elements in the set lessthan given value.
     * @param toElement variable to the set.
     * @return returns the array of elements
     * less than the given value in the set.
     */
    public int[] headSet(final int toElement) {
        return subSet(set[0], toElement);
    }
    /**
     * method to return the last element in the set.
     * @return returns the last element in the set.
     */
    public void last() {
        try{
        if (size != 0) {
            System.out.println(set[size - 1]);
        } else{
            throw new Exception("Set Empty Exception");
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
/**
 * method to find intersection of two sets.
 * @param t new set "t".
 * @return returns the intersection of two sets.
 */
    public String intersection(final Set t) {
        if (this.size == 0 || t.size == 0) {
            return "{}";
        }

        Set i = new Set();

    for (int k = 0; k < this.size; k++) {
        for (int j = 0; j < t.size; j++) {
            if (this.set[k] == t.list[j]) {
               i.add(set[k]);
            }
        }
    }
    return i.toString();
    }
    /**
     * method to retain the elements in two sets.
     * @param intArray  The integer array.
     * @return returns the retained set of given sets.
     */
    public SortedSet retainAll(final int[] intArray) {
        SortedSet outputSet = new SortedSet();
        for (int i : this.set) {
            for (int j = 0; j < intArray.length; j++) {
                if (i == intArray[j]) {
                    outputSet.add(i);
                }
            }
        }
        return outputSet;
    }
}

    /**
     * sorted set.
     */
/**
 * Solution class for code-eval.
 */
public class Solution {
    /**
     * Constructor for the solution class.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s  string input from test case file.
     *
     * @return int array from the given string.
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
     * main function for solution class.
     *
     * @param  args  The arguments
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
            // based on the list operation
            // invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.
                    contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "intersection":
                s = new SortedSet();
                Set t = new Set();
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                // System.out.println(s);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "addAll":
                intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.addAll(intArray);
                }
                break;
            case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "subSet":
                String[] arrstring = tokens[1].split(",");
                try{
                if (Integer.parseInt(arrstring[0])
                      > Integer.parseInt(arrstring[1])) {
                    throw new Exception("Invalid Arguments to Subset Exception");
                } else {
                    int[] subarray = s.subSet(Integer.parseInt(arrstring[0]),
                            Integer.parseInt(arrstring[1]));
                    SortedSet subset = new SortedSet();
                    subset.addAll(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }

                break;
            case "headSet":

                try {
                    if (Integer.parseInt(tokens[1]) <= s.get(0)) {
                        throw new Exception("Set Empty Exception");
                    } else {
                        int[] headarray = s.headSet(Integer.parseInt(tokens[1]));
                        SortedSet headset = new SortedSet();
                        headset.addAll(headarray);
                        if (headset != null) {
                        System.out.println(headset);
                        }
                    }
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
            case "last":
                s.last();
                break;
            default:
                break;
            }
        }
    }
}
