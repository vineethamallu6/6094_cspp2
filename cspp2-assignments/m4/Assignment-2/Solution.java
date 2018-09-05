/**missing.
*/import java.util.Scanner;
/**main class.
*/
public final class  Solution {
    /**
    main class.
    */
    private Solution() {
    /**constructior.
    */
    }
    /**main function.
    *@param args String.
    */
    public static void main(final String[] args) {
        int m, n, i, j, p, q, k, l;
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();
        int[][] matrixOne = new int[m][n];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                matrixOne[i][j] = s.nextInt();
            }
        }
        p = s.nextInt();
        q = s.nextInt();
        int[][] matrixTwo = new int[p][q];
        int[][] resultMatrix = new int[m][q];

        for (k = 0; k < p; k++) {
            for (l = 0; l < q; l++) {
                matrixTwo[k][l] = s.nextInt();
            }
        }
        if (m == p && n == q) {
            for (i = 0; i < m; i++) {
            for (l = 0; l < q; l++) {
                resultMatrix[i][l] = matrixOne[i][l] + matrixTwo[i][l];
            }
        }
         for (i = 0; i < m; i++) {
            for (l = 0; l < q - 1; l++) {
                System.out.print(resultMatrix[i][l] + " ");
            }
            System.out.println(resultMatrix[i][q - 1]);
        }
    } else {
        System.out.println("not possible");
    }
}
}
