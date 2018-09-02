import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**
     * Constructs the object.
     */
    public static final int N_U_M = 100;
    /**.
    number
    */
    public static final int N_O = 50;
    /**.
    num
    */
    public static final int N_U = 150;
    /**.
    nu
    */
    public static final int N_B = 200;
    /**.
    * n
    */
    public static final int N_M = 250;
    /**.
    num
    */
    public static final int N_E = 300;
    /**.
    num
    */
    public static final int N_R = 350;
    /**.
    * num
    */
    public static final int N_I = 400;
    /**.
    num
    */
    public static final int N_J = 450;
    /**.
    num
    */
    public static final int N_K = 500;
    /**.
    num
    */
    public static final int N_L = 550;
    /**.
    num
    */
    public static final int N_P = 600;
    /**.
    num
    */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
                                final int rows, final int columns) {
        int i, j;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                int value = a[i][j];
                if (value < N_U_M && value > 0) {
                    if (value >= N_O) {
                    a[i][j] = N_U_M;
                }   else {
                    a[i][j] = 0;
                }
                }
                if (value > N_U_M && value < N_B) {
                    if (value < N_U) {
                      a[i][j] = N_U_M; 
                }   else { a[i][j] = N_B; }
              } else if (value > N_B && value < N_E) {
                    if (value < N_M) { 
                        a[i][j] = N_B; 
                  } else { a[i][j] = N_E; }
              
              } else if (value > N_E && value <= N_I) {
                    if (value < N_R) { 
                        a[i][j] = N_E; 
                  } else { a[i][j] = N_I; }
               
            }   else if (value > N_I && value < N_K) {
                    if (value < N_J) { 
                        a[i][j] = N_I; 
                  } else { a[i][j] = N_K; }
                
              } else if (value > N_K && value < N_P) {
                    if (value < N_L) { 
                        a[i][j] = N_K; 
                  } else { a[i][j] = N_P; }
                }
            }
        }
        return a;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
