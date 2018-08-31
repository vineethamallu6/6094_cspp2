/**binary string.
*/
import java.util.Scanner;
/**import
*/
public final class Solution {
/**
	Do not modify this main function.
	*/
	public static final int N_U_M = 10;
	/**
	Number.
	*/
	private Solution() {
	/**constructtor.
	*/
	}
	/**main function.
	*@param args String
	*/
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			String res = binaryToDecimal(s);
			System.out.println(res);
		}
	}
	/**function.
	*@param str String.
    */
	public static String binaryToDecimal(final String str) {
		 int decimal = 0, i = 0;
		 long n = Long.parseLong(str);
		 while (n != 0) {
		 	decimal += ((n % N_U_M) * Math.pow(2, i));
		 	n = n / N_U_M;
		 	i++;
		 }
		 String s1 = decimal + "";
		 return s1;

	}

}
