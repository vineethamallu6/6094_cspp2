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
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reverseString(s);	
		System.out.println(reverse);
	}
	/**
	reverseString function.
	*@return String
	/**parameters.
	*@param s String
	*/
	public static String reverseString(String s) {
		String rev = "";
		for (int i = 0; i < s.length(); i++) {
			rev = s.charAt(i) + rev;
		}
		return rev;
	}
}
