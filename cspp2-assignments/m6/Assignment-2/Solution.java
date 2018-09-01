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
    static int[][] roundHundred(final int[][] a, final int rows, final int columns) {
        int i, j;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                int value = a[i][j];
                if (value < 100 && value > 0) {
                    if (value >= 50) {
                    a[i][j] = 100;
                }
                    else {
                    a[i][j] = 0;
                }
                }
                if (value > 100 && value < 200) {
                    if (value < 150) {
                      a[i][j] = 100;
                    }
                    else {
                      a[i][j] = 200;  
                    }
                }
                else if (value > 200 && value < 300) { 
                    if (value < 250) {
                      a[i][j] = 200;
                    }
                    else {
                      a[i][j] = 300; 
                    }
              }
                else if (value > 300 && value <= 400) {
                    if (value < 350) {
                      a[i][j] = 300;
                    }
                    else {
                      a[i][j] = 400; 
                    }
                }
                else if (value > 400 && value < 500) {
                    if (value < 450) {
                      a[i][j] = 400;
                    }
                    else {
                      a[i][j] = 500; 
                    }
                }
                else if (value > 500 && value < 600) {
                    if(value < 550) {
                      a[i][j] = 500;
                    }
                    else {
                      a[i][j] = 600; 
                    }
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
