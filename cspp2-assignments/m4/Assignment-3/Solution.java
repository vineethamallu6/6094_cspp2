/**binary string.
*/
import java.util.Scanner;
/**import.
*/
public final class Solution {
/**
    Do not modify this main function.
    */
    public static final int num = 10;
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
        int sizeOfArray = sc.nextInt();
        for (int i = 0; i < sizeOfArray; i++) {
            String givenString = sc.next();
            String result = binaryToDecimal(givenString);
            System.out.println(result);
        }
    }
    /**
    function.
    *@return String
    /**
    *@param str String.
    */
    public static String binaryToDecimal(final String str) {
         int decimal = 0, i = 0;
         long number = Long.parseLong(str);
         while (number != 0) {
            decimal += ((number % num) * Math.pow(2, i));
            number = number / num;
            i++;
         }
         String resultString = decimal + "";
         return resultString;

    }

}
