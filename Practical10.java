import java.util.Scanner;
class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.print("Enter number of items: ");
        n = sc.nextInt();
        int[] p = new int[n + 1];
        int[] w = new int[n + 1];
        System.out.println("Enter profits:");
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        System.out.println("Enter weights:");

        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }

        System.out.print("Enter capacity: ");
        m = sc.nextInt();

        int[][] k = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else if (w[i] <= j) {
                    k[i][j] = Math.max(p[i] + k[i - 1][j - w[i]], k[i - 1][j]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }

        System.out.println("Maximum profit = " + k[n][m]);
    }
}
