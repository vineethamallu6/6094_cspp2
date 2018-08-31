/**missing.
*/
import java.util.Scanner;
/**main class.
*/
public final class Solution {
/**Fill.
    */
    private Solution() {
        /**constructor.
        */
    }
    /**main function.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
