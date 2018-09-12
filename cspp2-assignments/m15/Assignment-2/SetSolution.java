import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
/**
 * Class for set.
 */
/**program.**/
class Set {

    //your code goes here...
    //Good luck :-)
    /**
     * { var_description }.
     */
    public int size;
    /**
     * { var_description }.
     */
    public int[] list;
    /**
     * Constructs the object.
     */

    Set() {
        final int ten = 10;
        list = new int[ten];
        size = 0;

    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */

    public int size() {
        return size;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */

    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
            return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the object..
     *
     * @return     String representation of the object.
     */

    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ", ";
        }
        str = str + list[i] + "}";
        return str;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     */

    public void add(final int item) {
        //Inserts the specified element at the end of the zelist.
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] != item) {
                count++;
            }
        }
        if (count == size) {
            list[size++] = item;
        }

    }
    /**
     * { function_description }.
     *
     * @param      items  The items
     */

    public void add(final int[] items) {
        // write the logic
        if (items.length > list.length) {

            resize(list.length);
        }
           for (int i : items) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (list[j] != i) {
                    count++;
                }

            }
            if (count == size) {
                list[size++] = i;
            }

        }
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     */

    private void resize(final int x) {

        list = Arrays.copyOf(list, 2 * x);
    }
    /**
     * { function_description }.
     *
     * @param      t     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */


    public String intersection(final Set t) {
        if (this.size == 0 || t.size == 0) {
            return "{}";
        }

        Set i = new Set();

    for (int k = 0; k < this.size; k++) {
        for (int j = 0; j < t.size; j++) {
            if (this.list[k] == t.list[j]) {
               i.add(list[k]);
            }
        }
    }

        return i.toString();
        // System.out.println(t.toString());
    }
    /**
     * { function_description }.
     *
     * @param      intArray  The int array
     *
     * @return     { description_of_the_return_value }
     */

    public String retainAll(final int[] intArray) {
        if (this.size == 0 || intArray.length == 0) {
          return "{}";
        }
        // for(int i = 0; i<intArray.length; i++)
        //  System.out.println(intArray[i]);
        // return intArray;
        Set r = new Set();
        for (int i : this.list) {
            for (int j = 0; j < intArray.length; j++) {
                if (i == intArray[j]) {
                    r.add(i);
                }
            }
        }
        return r.toString();
    }
    /**
     * { function_description }.
     *
     * @param      t     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */

    public int[][] cartesianProduct(final Set t) {
        // if(t.size == 0 || this.size == 0) {
        //  return "null";
        // }
        int c = this.size * t.size;
        int[][] arr;
        arr = new int[c][2];
        int i = 0;
            for (int k = 0; k < this.size; k++) {
                for (int j = 0; j < t.size; j++) {

                arr[i][0] = this.list[k];
                arr[i][1] = t.list[j];
                i++;

                }
            }

    return arr;

    }
}
/**
 * Solution class for code-eval.
 */
public class SetSolution {
    /**
     * Constructs the object.
     */
    protected SetSolution() {

    }

    /**
     * helper function to convert string input to int array.
     *
     * @param      s string input from test case file.
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
        Set s = new Set();
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
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                int a = s.size();
                intArray = intArray(tokens[2]);
                t.add(intArray);
                int b = t.size();

                if (a == 0 || b == 0) {
                    System.out.println("null");
                } else {
    System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                }

                break;
                default:
                break;
            }
        }
    }
}


