/**missing.
*/
import java.util.Scanner;
/**Do not modify this main function.
*/
public final class Solution {
    /**program to find gcd.
    */
    private Solution() {
    /**constructor.
    */
    }
    /**main function.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOne = s.nextInt();
        int numberTwo = s.nextInt();
        gcd(numberOne, numberTwo);
        System.out.println(gcd(numberOne, numberTwo));
    }
    /**
    gcd function.
    *@return int
    /**
    Need to write the gcd function and print the output.
    *@param a int
    *@param b int
    */
    public static int gcd(final int a, final int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);
        }
        /*if (b==0) return a;
        return gcd(b,a%b);*/
    }
