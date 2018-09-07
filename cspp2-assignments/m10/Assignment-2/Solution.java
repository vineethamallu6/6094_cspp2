import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 *A Class is implemented for Student details.
 */
class Student {
    /**
    * String name.
    */
    private String name;
    /**A constructor used to initialize the instance variables.
    *@param n string
    */
    Student(final String n) {
        this.name = n;
    }
    /**
     *Getter method which returns the value of instance.
     *variable.
     *@return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * whether the students names are equal or not.
     * @param      other  boolean other
     * @return     { boolean value }
     */
    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Student)) {
            return false;
        }
        Student that = (Student) other;
        return this.getName().equals(that.getName());
    }
    @Override
    public int hashCode() {
        return this.hashCode();
    }
    /** the method is used to print the name.
    *@return name string
    */
    public String toString() {
        return this.name;
    }
}
/**
* this is main class.
*/
public final class Solution {
    /**this is a constructor.
    */
    private Solution() {
    }
    /**
    * the method to do the operations.
    *@param stdin Scanner
    */
    public static void objectMethod(final Scanner stdin) {
        List<Student> listStudent = new List();
            while (stdin.hasNext()) {
                String line = stdin.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listStudent.add(new Student(tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Student[] temp = new Student[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = new Student(t1[i]);
                        }
                        listStudent.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listStudent.size());
                    break;
                case "print":
                    System.out.println(listStudent);
                    break;
                case "remove":
                    listStudent.remove(Integer.parseInt(
                    tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listStudent.indexOf(
                    new Student(tokens[1])));
                    break;
                case "get":
                    System.out.println(listStudent.get(
                    Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listStudent.contains(
                    new Student(tokens[1])));
                    break;
                default:
                    break;
                }
                }
}
   /** the double method.
    *@param stdin Scanner
    */
    public static void doubleMethod(final Scanner stdin) {
            List<Double> listDouble = new List();
            while (stdin.hasNext()) {
                String line = stdin.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listDouble.add(Double.parseDouble(
                    tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Double[] temp = new Double[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = Double.parseDouble(t1[i]);
                        }
                        listDouble.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listDouble.size());
                    break;
                case "print":
                    System.out.println(listDouble);
                    break;
                case "remove":
                    listDouble.remove(
                    Integer.parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listDouble.indexOf(
                        Double.parseDouble(tokens[1])));
                    break;
                case "get":
                    System.out.println(listDouble.get(
                        Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listDouble.contains(
                        Double.parseDouble(tokens[1])));
                    break;
                default: break;
                }
            }
    }
    /** the method on char type.
    *@param stdin Scanner
    */
    public static void charMethod(final Scanner stdin) {
        List<Character> listCharacter = new List();
        while (stdin.hasNext()) {
                String line = stdin.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listCharacter.add(tokens[1].charAt(0));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Character[] temp = new Character[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = t1[i].charAt(0);
                        }
                        listCharacter.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listCharacter.size());
                    break;
                case "print":
                    System.out.println(listCharacter);
                    break;
                case "remove":
                    listCharacter.remove(Integer.parseInt(
                        tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listCharacter.indexOf(
                        tokens[1].charAt(0)));
                    break;
                case "get":
                    System.out.println(listCharacter.get(
                    Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listCharacter.contains(
                    tokens[1].charAt(0)));
                    break;
                default: break;
                }
            }
    }
    /**this is main method.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        String objectType = stdin.nextLine();
        switch (objectType) {
        case "S":
            List<String> listString = new List();
            while (stdin.hasNext()) {
                String line = stdin.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listString.add(tokens[1]);
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        listString.addAll(t1);
                    }
                    break;
                case "size":
                    System.out.println(listString.size());
                    break;
                case "print":
                    System.out.println(listString);
                    break;
                case "remove":
                    listString.remove(Integer.parseInt(
                    tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listString.indexOf(
                    tokens[1]));
                    break;
                case "get":
                    System.out.println(listString.get(
                    Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listString.contains(
                    tokens[1]));
                    break;
                default: break;
                }
            }
            break;
        case "I":
            List<Integer> listInteger = new List();
            while (stdin.hasNext()) {
                String line = stdin.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listInteger.add(Integer.parseInt(tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Integer[] temp = new Integer[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        listInteger.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listInteger.size());
                    break;
                case "print":
                    System.out.println(listInteger);
                    break;
                case "remove":
                    listInteger.remove(Integer.parseInt(
                    tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listInteger.indexOf(
                    Integer.parseInt((tokens[1]))));
                    break;
                case "get":
                    System.out.println(listInteger.get(
                    Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listInteger.contains(
                    Integer.parseInt((tokens[1]))));
                    break;
                default: break;
                }
            }
            break;
        case "F":
            List<Float> listFloat = new List();
            while (stdin.hasNext()) {
                String line = stdin.nextLine();
                // split the line using space
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listFloat.add(Float.parseFloat(tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Float[] temp = new Float[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = Float.parseFloat(t1[i]);
                        }
                        listFloat.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listFloat.size());
                    break;
                case "print":
                    System.out.println(listFloat);
                    break;
                case "remove":
                    listFloat.remove(Integer.parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listFloat.indexOf(
                    Float.parseFloat(tokens[1])));
                    break;
                case "get":
                    System.out.println(listFloat.get(
                    Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listFloat.contains(
                    Float.parseFloat(tokens[1])));
                    break;
                default: break;
                }
            }
            break;
        case "C":
            charMethod(stdin);
            break;
        case "D":
            doubleMethod(stdin);
            break;
        case "O":
            objectMethod(stdin);
            break;
        default:
                break;
        }
    }
}




