import java.util.Scanner;
class MatrixChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter number of matrices: ");
        n = sc.nextInt();
        int[] p = new int[n + 1];
        int[][] m = new int[n + 1][n + 1];
        System.out.println("Enter dimensions:");

        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        for (int d = 1; d < n; d++) {
            for (int i = 1; i <= n - d; i++) {
                int j = i + d;
                m[i][j] = 99999;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        System.out.println("Minimum multiplications = " + m[1][n]);
    }
}
