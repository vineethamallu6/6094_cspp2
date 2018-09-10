/**import.
*/
import java.util.Scanner;
/**main.
*/
public final class Solution {
/**
Do not modify the main function.
*/
    private Solution() {
    /**constructor.
    */
    }
    /**
    main function.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String givenString = sc.nextLine();
        String reverse = reverseString(givenString);
        System.out.println(reverse);
    }
    /**
    reverseString function.
    *@return String
    /**parameters.
    *@param s String
    */
    public static String reverseString(final String stringGiven) {
        String rev = "";
        for (int i = 0; i < stringGiven.length(); i++) {
            rev = stringGiven.charAt(i) + rev;
        }
        return rev;
    }
}
