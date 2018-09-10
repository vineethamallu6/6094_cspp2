import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
	private int size;
    private int[] list;
    public Set() {
    	list = new int[10];
    	size = 0;
    }

    /**
     *
     *
     * @param      capacity  The capacity
     */
    public Set(int capacity){
       list=new int[capacity];
       size = 0;
    }
    public int size(){
    	return size;
    }
    public boolean contains(int item){
    	int count=0;
    	for (int i=0; i<size; i++){
          if (list[i] == item) {
          count++;
          }
      }
          if(count>0){
          	return true;
          }
          return false;


    }
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
        if (list[0] == 0) {
            str += "\nInvalid Position Exception";
        }
        return str;
     }

public void add(int item) {
    if (size == list.length) {
            resize();
        } else {
            if (!this.contains(item)) {
	list[size++] = item;
}
}
}
/**
 * { function_description }
 *
 * @param      newArray  The new array
 */
//public void add(int []newArray) {
	//if ((size() + newArray.length) > 10) {
            //list = resize();
        //}
        //int j = 0;
        //for (int i = size; i < (size + newArray.length); i++) {
        //list[i] = newArray[j];
        //j++;
        //}
        //size = size + newArray.length;
    //}
    public void add(final int[] items) {
        for (int element : items) {
           add(element);
        }
    }
    private int[] resize() {
     return Arrays.copyOf(list, 2 * list.length);
 }
 	public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
    }
}

 public Set intersection(Set otherSet) {
 	Set intersection = new Set();
 	int j = 0;
 	for (int i = 0; i < size; i++) {
 		for (j=0;j<otherSet.size();j++) {
 		if(list[i]==otherSet.get(j)) {
 			intersection.add(list[i]);
 			//System.out.println(j);
 			//System.out.println(i);
 		}
 		}
 	}
 	return intersection;
 }
 	public Set retainAll(int[] anotherArray) {
 		Set result = new Set();
 	int j = 0;
 	for (int i = 0; i < size; i++) {
        for (j=0;j<anotherArray.length;j++){
 		if(list[i]==anotherArray[j]) {
 			result.add(anotherArray[j]);
 			j++;
 		}
    }
 	}
 	return result;
 }

public int[][] cartesianProduct(Set anotherSet) {
	int row = this.size() * anotherSet.size();
        int col = 2;
        int[][] product = new int[row][col];
        if (size==0) {
        	return null;
        }
        else {
        int k = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < anotherSet.size(); j++) {
                product[k][0] = this.get(i);
                product[k][1] = anotherSet.list[j];
                k += 1;
            }
        }
        return product;
    }
}
}


/**
 * Solution class for code-eval.
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
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
