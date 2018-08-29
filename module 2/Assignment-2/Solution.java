import java.util.Scanner;
/**missing doc.
*/
public final class Solution {
    /** the program is to find the roots.
    */
    private Solution() {
    /** this is a constructor.
    */
    }
    /**
    Do not modify this main function.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        roots(a, b, c);
    }
    /**
    *Need to write the rootsOfQuadraticEquation function and print the output.
    *@param p int
    *@param q int
    *@param r int
    */
    public static void roots(final int p, final int q, final int r) {
        double d = (q * q) - (2 * 2 * p * r);
        double qua = Math.sqrt(d);
        double r1 = ((-q + qua) / (2 * p));
        double r2 = ((-q - qua) / (2 * p));
        System.out.println(r1 + " " + r2);
    }
}



