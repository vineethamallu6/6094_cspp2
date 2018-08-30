/**missing.
*/
import java.util.Scanner;
/**Do not modify this main function.
*/
public final class Solution {
    /**Fill the main function to print the number of 7's between 1 to n.
    */
    public static final int N_U_M = 7;
    /**.
    number
    */
    public static final int N_O = 10;
    /**.
    number
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
        int n = s.nextInt();
        int count = 0;
        int temp = 1;

        for (int i = 0; i <= n; i++) {
            temp = i;
            while (temp > 0) {
            int digit = temp % N_O;
            temp = temp / N_O;
            if (digit == N_U_M) {
                count++;
            }
        }
    }
    System.out.println(count);
}
}