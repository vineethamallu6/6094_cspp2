/**.
    * this is main class.
*/
import java.util.Scanner;
/**.
    *  function for taking user inputs
*/
public final class Solution {
    /**.
    Do not modify this main function.
    */
    private Solution() {
        /**
        this is constructor.
        */
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**.
    the power function.
    *@return float
    /**
    * comment of function
    * @param b **this is base number**
    * @param e **this is exponent number**
    */
    public static long power(final int b, final int e) {
        if (e != 0) {
            return (b * power(b, e - 1));
        } else {
            return 1;
        }
    }
}


